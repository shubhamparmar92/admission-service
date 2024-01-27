package com.sunrise.admissionservice.service.impl;

import com.sunrise.admissionservice.dto.request.Admission;
import com.sunrise.admissionservice.dto.response.AdmissionResponse;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import com.sunrise.admissionservice.mapper.AdmissionEntityMapper;
import com.sunrise.admissionservice.mapper.ClassEntityMapper;
import com.sunrise.admissionservice.model.AdmissionEntity;
import com.sunrise.admissionservice.model.ClassEntity;
import com.sunrise.admissionservice.repository.AdmissionRepository;
import com.sunrise.admissionservice.service.AdmissionService;
import com.sunrise.admissionservice.service.ClassService;
import com.sunrise.admissionservice.service.helper.AdmissionServiceHelper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.sunrise.admissionservice.constant.AdmissionConstant.APPROVED;
import static com.sunrise.admissionservice.constant.AdmissionConstant.REJECTED;

@Service
@Slf4j
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    AdmissionRepository repository;

    @Autowired
    AdmissionServiceHelper helper;

    AdmissionEntityMapper mapper = Mappers.getMapper(AdmissionEntityMapper.class);

    @Autowired
    ClassService classService;

    @Override
    public Integer addCandidate(Admission request) throws RecordNotFoundException {
        log.debug("Adding Candidate to process: {}", request);

        AdmissionEntity admissionEntity = mapper.toEntity(request);

        ClassEntity classEntity = classService.getClassDetailsById(Integer.parseInt(request.getCandidate().getClassDetails()));
        admissionEntity.getCandidate().setClassId(classEntity.getId());

        return repository.save(admissionEntity).getId();

    }

    @Override
    public List<AdmissionResponse> fetchAll() throws RecordNotFoundException {

        List<AdmissionEntity> admissionEntityList = repository.findAll();
        if (CollectionUtils.isEmpty(admissionEntityList))
            throw new RecordNotFoundException("No Data Found");
        List<Integer> classIds = admissionEntityList.stream().filter(e -> !REJECTED.equals(e.getStatus()) && Objects.nonNull(e.getCandidate())).map(e -> e.getCandidate().getClassId()).toList();
        List<AdmissionResponse> admissionResponses = mapper.toDTOList(admissionEntityList);
        if (!classIds.isEmpty()) {
            List<ClassEntity> classEntityList = classService.getClassDetailsByIdList(classIds);
            updateAllClassDetails(admissionResponses, classEntityList);
        }
        return admissionResponses;
    }

    @Override
    public AdmissionResponse fetchById(String id) throws RecordNotFoundException {

        Optional<AdmissionEntity> responseOptional = repository.findById(Integer.parseInt(id));
        if (responseOptional.isEmpty())
            throw new RecordNotFoundException("No Data Found");
        AdmissionEntity response = responseOptional.get();
        AdmissionResponse admissionResponse = mapper.toDTO(response);
        if (!REJECTED.equals(response.getStatus())) {
            ClassEntity classEntity = classService.getClassDetailsById(response.getCandidate().getClassId());
            updateClassDetails(admissionResponse, classEntity);
        }

        return admissionResponse;
    }

    @Override
    @Transactional
    public AdmissionResponse updateCandidate(String id, Admission request) throws RecordNotFoundException {
        log.debug("Updating Candidate to process: {}", request);
        Optional<AdmissionEntity> response = repository.findById(Integer.parseInt(id));
        if (response.isEmpty())
            throw new RecordNotFoundException("No Data Found");
        AdmissionEntity admissionEntity = response.get();
        ClassEntity classEntity = updateAdmissionDetails(admissionEntity, request);
        AdmissionResponse admissionResponse = mapper.toDTO(admissionEntity);
        if (!REJECTED.equals(request.getStatus()))
            updateClassDetails(admissionResponse, classEntity);
        if(APPROVED.equals(request.getStatus()))
            helper.saveAsStudent(admissionResponse);

        return admissionResponse;
    }


    private ClassEntity updateAdmissionDetails(AdmissionEntity admissionEntity, Admission request) throws RecordNotFoundException {
        ClassEntity classEntity = null;
        if (REJECTED.equals(request.getStatus().toUpperCase(Locale.ROOT))) {
            admissionEntity.getCandidate().setClassId(0);
        } else if (APPROVED.equals(request.getStatus().toUpperCase(Locale.ROOT))) {
            classEntity = classService.getClassDetailsById(Integer.parseInt(request.getCandidate().getClassDetails()));
            admissionEntity.getCandidate().setClassId(classEntity.getId());
        }
        admissionEntity.setStatus(request.getStatus());

        return classEntity;
    }

    private void updateClassDetails(AdmissionResponse admissionResponse, ClassEntity classEntity) {
        log.debug("Updating class Details");
        ClassEntityMapper mapperClass = Mappers.getMapper(ClassEntityMapper.class);
        admissionResponse.getCandidate().setClassDetails(mapperClass.toDto(classEntity));
        log.debug("Successfully updated class Details");
    }

    private void updateAllClassDetails(List<AdmissionResponse> admissionResponses, List<ClassEntity> classEntityList) {
        log.debug("Updating all class Details");
        Map<Integer, ClassEntity> classIdMap = classEntityList.stream().collect(Collectors.toMap(e -> e.id, e -> e));
        ClassEntityMapper mapperClass = Mappers.getMapper(ClassEntityMapper.class);
        admissionResponses.forEach(admissionResponse -> admissionResponse.getCandidate().setClassDetails(
                mapperClass.toDto(classIdMap.get(admissionResponse.getCandidate().getClassId()))));
        log.debug("Successfully updated class Details");
    }

}

package com.sunrise.admissionservice.service.impl;

import com.sunrise.admissionservice.dto.request.Admission;
import com.sunrise.admissionservice.dto.response.AdmissionResponse;
import com.sunrise.admissionservice.exception.APIResponseException;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import com.sunrise.admissionservice.mapper.AdmissionEntityMapper;
import com.sunrise.admissionservice.model.AdmissionEntity;
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

import java.util.List;
import java.util.Optional;

import static com.sunrise.admissionservice.constant.AdmissionConstant.APPROVED;

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
        return repository.save(admissionEntity).getId();

    }

    @Override
    public List<AdmissionResponse> fetchAll() throws RecordNotFoundException {

        List<AdmissionEntity> admissionEntityList = repository.findAll();
        if (CollectionUtils.isEmpty(admissionEntityList))
            throw new RecordNotFoundException("Candidates list Empty");
        return mapper.toDTOList(admissionEntityList);
    }

    @Override
    public AdmissionResponse fetchById(String id) throws RecordNotFoundException {

        Optional<AdmissionEntity> responseOptional = repository.findById(Integer.parseInt(id));
        if (responseOptional.isEmpty())
            throw new RecordNotFoundException("No Data Found");
        AdmissionEntity response = responseOptional.get();
        return mapper.toDTO(response);
    }

    @Override
    @Transactional
    public AdmissionResponse updateCandidate(String id, Admission request) throws RecordNotFoundException, APIResponseException {
        log.debug("Updating Candidate to process: {}", request);
        Optional<AdmissionEntity> response = repository.findById(Integer.parseInt(id));
        if (response.isEmpty())
            throw new RecordNotFoundException("No Data Found");
        AdmissionEntity admissionEntity = response.get();

        AdmissionResponse admissionResponse = mapper.toDTO(admissionEntity);
        if(APPROVED.equals(request.getStatus()))
        {
            helper.saveAsStudent(admissionResponse);
            admissionEntity.getCandidate().setSection(request.getCandidate().getSection());}
        admissionEntity.setStatus(request.getStatus());
        return admissionResponse;
    }





}

package com.sunrise.admissionservice.service.impl;

import com.sunrise.admissionservice.dto.request.Admission;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import com.sunrise.admissionservice.model.ClassEntity;
import com.sunrise.admissionservice.repository.ClassRepository;
import com.sunrise.admissionservice.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;

    public ClassEntity getClassDetailsByName(String className) throws RecordNotFoundException {
        log.debug("Getting Class details");

        Optional<ClassEntity> response = classRepository.findByName(className.toLowerCase(Locale.ROOT));

        if(response.isEmpty())
            throw new RecordNotFoundException("Class Details not found");


        return response.get();

    }

    public ClassEntity getClassDetailsById(int id) throws RecordNotFoundException {
        log.debug("Getting Class details");
        Optional<ClassEntity> response = classRepository.findById(id);

        if(response.isEmpty())
            throw new RecordNotFoundException("Class Details not found");


        return response.get();

    }

    public List<ClassEntity> getClassDetailsByIdList(List<Integer> ids) throws RecordNotFoundException {
        log.debug("Getting Class details list");
        List<ClassEntity> response = classRepository.findAllById(ids);

        if(response.isEmpty())
            throw new RecordNotFoundException("Class Details not found");


        return response;

    }
}

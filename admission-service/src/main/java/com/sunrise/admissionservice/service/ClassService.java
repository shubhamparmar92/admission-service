package com.sunrise.admissionservice.service;

import com.sunrise.admissionservice.dto.request.ClassDetails;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import com.sunrise.admissionservice.model.ClassEntity;

import java.util.List;

public interface ClassService {

    ClassEntity getClassDetailsByName(String className) throws RecordNotFoundException;

    ClassEntity getClassDetailsById(int id) throws RecordNotFoundException;

    List<ClassEntity> getClassDetailsByIdList(List<Integer> ids) throws RecordNotFoundException;

    Integer addClass(final ClassDetails request);
}

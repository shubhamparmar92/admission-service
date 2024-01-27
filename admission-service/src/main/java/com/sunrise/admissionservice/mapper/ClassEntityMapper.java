package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.dto.request.ClassDetails;
import com.sunrise.admissionservice.dto.response.ClassResponse;
import com.sunrise.admissionservice.model.ClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClassEntityMapper {

    @Mapping(source = "name", target = "name")
    ClassEntity toEntity(ClassDetails classDetails);

    ClassResponse toDto(ClassEntity request);

    List<ClassResponse> toDto(List<ClassEntity> request);
}

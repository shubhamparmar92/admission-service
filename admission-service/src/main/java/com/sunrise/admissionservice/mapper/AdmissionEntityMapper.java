package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.dto.request.Admission;
import com.sunrise.admissionservice.dto.response.AdmissionResponse;
import com.sunrise.admissionservice.model.AdmissionEntity;
import com.sunrise.admissionservice.model.ClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;

@Mapper(uses = {CandidateEntityMapper.class})

public interface AdmissionEntityMapper {

    @Mapping(target = "applicationDate", qualifiedByName = "defaultDate")
    AdmissionEntity toEntity(Admission request);
    AdmissionResponse  toDTO(AdmissionEntity entity);

    List<AdmissionResponse> toDTOList(List<AdmissionEntity> entity);

    @Named("defaultDate")
    default LocalDate setApplicationDate(LocalDate date) {
        return LocalDate.now();
    }
}

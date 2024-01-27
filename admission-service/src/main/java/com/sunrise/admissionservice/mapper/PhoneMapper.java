package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.dto.request.Phone;
import com.sunrise.admissionservice.dto.response.PhoneResponse;
import com.sunrise.admissionservice.model.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper
public interface PhoneMapper {

    @Mapping(target = "phoneNumber", source = "phoneNumber")
    PhoneEntity toEntity(Phone phone);

    List<PhoneEntity> toEntity(List<Phone> phone);

    PhoneResponse toDto(PhoneEntity request);

    List<PhoneResponse> toDto(List<PhoneEntity> request);
}

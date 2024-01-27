package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.dto.request.Address;
import com.sunrise.admissionservice.dto.response.AddressResponse;
import com.sunrise.admissionservice.model.AddressEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AddressEntityMapper {

    AddressEntity toEntity(Address address);

    List<AddressEntity> toEntity(List<Address> address);

    AddressResponse toDto(AddressEntity request);

    List<AddressResponse> toDto(List<AddressEntity> request);
}

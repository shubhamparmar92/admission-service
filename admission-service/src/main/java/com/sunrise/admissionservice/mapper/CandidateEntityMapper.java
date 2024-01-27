package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.dto.request.Candidate;
import com.sunrise.admissionservice.dto.response.CandidateResponse;
import com.sunrise.admissionservice.model.CandidateEntity;
import com.sunrise.admissionservice.model.ClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {ClassEntityMapper.class, AddressEntityMapper.class, PhoneMapper.class, EmailMapper.class})
public interface CandidateEntityMapper {


    List<CandidateEntity> toEntity(List<Candidate> request);
    @Mapping(target = "phoneList", source = "contact.phone")
    @Mapping(target = "emailList", source = "contact.email")
    @Mapping(target = "addressList", source = "contact.address")
    CandidateEntity toEntity(Candidate request);
    CandidateResponse toDto(CandidateEntity request);

    List<CandidateResponse> toDto(List<CandidateEntity> request);
}

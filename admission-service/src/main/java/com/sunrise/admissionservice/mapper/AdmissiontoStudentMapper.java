package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.client.request.StudentRequest;
import com.sunrise.admissionservice.dto.response.CandidateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AdmissiontoStudentMapper {

    @Mapping(target = "contact.phone", source = "phoneList")
    @Mapping(target = "contact.email", source = "emailList")
    @Mapping(target = "contact.address", source = "addressList")
    StudentRequest toStudentRequest(CandidateResponse request);
}

package com.sunrise.admissionservice.mapper;

import com.sunrise.admissionservice.dto.request.Email;
import com.sunrise.admissionservice.dto.response.EmailResponse;
import com.sunrise.admissionservice.model.EmailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmailMapper {

    EmailEntity toEntity(Email address);

    List<EmailEntity> toEntity(List<Email> address);

    EmailResponse toDto(EmailEntity request);

    List<EmailResponse> toDto(List<EmailEntity> request);
}

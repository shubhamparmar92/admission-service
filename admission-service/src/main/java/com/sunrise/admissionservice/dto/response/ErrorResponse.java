package com.sunrise.admissionservice.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {

    private HttpStatus errorCode;
    private String errorDescription;

}

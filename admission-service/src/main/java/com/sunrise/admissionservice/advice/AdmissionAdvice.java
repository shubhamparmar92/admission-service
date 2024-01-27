package com.sunrise.admissionservice.advice;

import com.sunrise.admissionservice.dto.response.ErrorResponse;
import com.sunrise.admissionservice.exception.APIResponseException;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdmissionAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(RecordNotFoundException ex)
    {
        return new ResponseEntity<>(ErrorResponse.builder()
                .errorCode(HttpStatus.NOT_FOUND)
                .errorDescription(ex.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(APIResponseException.class)
    public ResponseEntity<ErrorResponse> handle(APIResponseException ex)
    {
        return new ResponseEntity<>(ErrorResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorDescription(ex.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

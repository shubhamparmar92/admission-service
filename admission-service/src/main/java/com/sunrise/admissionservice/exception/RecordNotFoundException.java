package com.sunrise.admissionservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class RecordNotFoundException extends Throwable {

    public RecordNotFoundException(String message)
    {
        super(message);
        log.error(message);
    }

    public RecordNotFoundException(String message, HttpStatus status)
    {
        super(message);
        log.error(message, status);
    }
}

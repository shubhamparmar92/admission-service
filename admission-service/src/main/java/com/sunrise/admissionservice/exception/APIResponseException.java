package com.sunrise.admissionservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class APIResponseException extends Exception{

    public APIResponseException(String message)
    {
        super(message);
        log.error(message);
    }
}

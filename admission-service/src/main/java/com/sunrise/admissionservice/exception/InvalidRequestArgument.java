package com.sunrise.admissionservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidRequestArgument extends Throwable {

    public InvalidRequestArgument(String message)
    {
        log.error(message);
    }
}

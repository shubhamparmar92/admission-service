package com.sunrise.admissionservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DuplicateRecordException {

    public DuplicateRecordException(String message)
    {
        log.error(message);
    }
}

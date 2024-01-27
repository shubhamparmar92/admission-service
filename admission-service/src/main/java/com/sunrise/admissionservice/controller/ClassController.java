package com.sunrise.admissionservice.controller;

import com.sunrise.admissionservice.dto.request.ClassDetails;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import com.sunrise.admissionservice.service.ClassService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@Slf4j
public class ClassController {

    @Autowired
    ClassService service;

    @PostMapping
    public ResponseEntity<Integer> addClass(@Valid @RequestBody ClassDetails request) throws RecordNotFoundException {
        log.info("Request received to add a new class: {}", request);
        return new ResponseEntity<>(service.addClass(request), HttpStatus.CREATED);
    }
}

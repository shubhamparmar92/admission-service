package com.sunrise.admissionservice.controller;

import com.sunrise.admissionservice.dto.request.Admission;
import com.sunrise.admissionservice.dto.response.AdmissionResponse;
import com.sunrise.admissionservice.exception.APIResponseException;
import com.sunrise.admissionservice.exception.InvalidRequestArgument;
import com.sunrise.admissionservice.exception.RecordNotFoundException;
import com.sunrise.admissionservice.service.AdmissionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/admission")
@Slf4j
public class AdmissionController {

    @Autowired
    AdmissionService service;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Integer> addCandidate(@Valid @RequestBody Admission request) throws RecordNotFoundException {
        log.info("Request received for admission: {}", request);
        return new ResponseEntity<>(service.addCandidate(request), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<AdmissionResponse>> fetchAll() throws RecordNotFoundException {

            log.info("Request received to fetch all Candidates");
            return new ResponseEntity<>(service.fetchAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<AdmissionResponse> fetchById(@PathVariable String id) throws RecordNotFoundException {
        log.info("Request received to fetch Candidate by ID {}",id);
        return new ResponseEntity<>(service.fetchById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<AdmissionResponse> updateCandidate(@PathVariable String id,@Valid @RequestBody Admission request) throws InvalidRequestArgument, RecordNotFoundException, APIResponseException {
        if(Objects.isNull(request) || Objects.isNull(request.id))
            throw new InvalidRequestArgument("Request can not be Null/blank");
        log.info("Request received to update: {}", request);
        return new ResponseEntity<>(service.updateCandidate(id,request),HttpStatus.OK);
    }


}

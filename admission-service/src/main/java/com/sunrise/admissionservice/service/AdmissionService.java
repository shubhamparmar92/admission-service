package com.sunrise.admissionservice.service;

import com.sunrise.admissionservice.dto.request.Admission;
import com.sunrise.admissionservice.dto.response.AdmissionResponse;
import com.sunrise.admissionservice.exception.APIResponseException;
import com.sunrise.admissionservice.exception.RecordNotFoundException;

import java.util.List;

public interface AdmissionService {

    Integer addCandidate(Admission request) throws RecordNotFoundException;

    List<AdmissionResponse> fetchAll() throws RecordNotFoundException;

    AdmissionResponse updateCandidate(String id, Admission request) throws RecordNotFoundException, APIResponseException;

    AdmissionResponse fetchById(String id) throws RecordNotFoundException;

}

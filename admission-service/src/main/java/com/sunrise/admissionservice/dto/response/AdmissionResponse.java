package com.sunrise.admissionservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdmissionResponse {
    public int id;
    public int formNumber;
    public String status;
    public LocalDate applicationDate;
    public CandidateResponse candidate;

}
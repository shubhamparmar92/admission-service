package com.sunrise.admissionservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Admission {

    public int id;
    public int formNumber;
    @NotBlank(message = "Status is required.")
    public String status;
    public LocalDate applicationDate;
    @NotEmpty(message = "Candidate is required.")
    public Candidate candidate;
}

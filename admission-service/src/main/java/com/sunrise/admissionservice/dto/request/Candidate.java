package com.sunrise.admissionservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Candidate {

    public int id;

    @NotEmpty(message = "first Name is required")
    public String firstName;

    @NotEmpty(message = "last Name is required")
    public String lastName;

    @NotEmpty(message = "father Name is required")
    public String fatherName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    public String dob;

    @NotNull(message = "contact detail is required")
    public Contact contact;

    @NotNull(message = "class details is required")
    public String classDetails;

}

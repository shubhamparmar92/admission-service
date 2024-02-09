package com.sunrise.admissionservice.client.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentRequest {

    public String firstName;
    public String lastName;
    public String fatherName;
    public String dob;
    public ContactDetail contact;
    public String section;
    public String className;

}

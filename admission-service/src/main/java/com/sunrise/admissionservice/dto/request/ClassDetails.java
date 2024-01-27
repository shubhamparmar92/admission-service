package com.sunrise.admissionservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClassDetails {

    int id;
    public String section;

    @NotEmpty(message = "class name is required")
    public String name;

}

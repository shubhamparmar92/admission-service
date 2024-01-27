package com.sunrise.admissionservice.client.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClassDetail {

    int id;
    public String section;

    @NotEmpty(message = "class name is required")
    public String name;

}

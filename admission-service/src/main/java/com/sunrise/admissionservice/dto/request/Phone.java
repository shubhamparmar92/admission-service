package com.sunrise.admissionservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Phone {

    int id;

    @NotEmpty(message = "phone number is required")
    public Long phoneNumber;
}

package com.sunrise.admissionservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    public List<Phone> phone;
    public List<Address> address;
    public List<Email> email;
}
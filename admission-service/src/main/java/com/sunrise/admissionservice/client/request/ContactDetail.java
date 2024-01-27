package com.sunrise.admissionservice.client.request;

import lombok.Data;

import java.util.List;

@Data
public class ContactDetail {

    public List<Phone> phone;
    public List<Address> address;
    public List<Email> email;
}

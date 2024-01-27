package com.sunrise.admissionservice.client.request;

import lombok.Data;
@Data
public class Address {

    int id;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public int pinCode;
}

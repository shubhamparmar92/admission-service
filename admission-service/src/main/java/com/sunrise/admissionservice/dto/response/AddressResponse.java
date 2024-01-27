package com.sunrise.admissionservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {
    public int id;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public int pinCode;
}

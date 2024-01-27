package com.sunrise.admissionservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public int pinCode;
}

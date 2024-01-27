package com.sunrise.admissionservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Phone")
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    public Long phoneNumber;
}

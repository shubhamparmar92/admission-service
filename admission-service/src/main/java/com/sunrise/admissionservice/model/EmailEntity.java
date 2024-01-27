package com.sunrise.admissionservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "email")
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String email;
}

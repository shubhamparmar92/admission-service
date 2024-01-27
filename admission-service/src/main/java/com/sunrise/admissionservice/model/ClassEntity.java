package com.sunrise.admissionservice.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "class")
@Data
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String section;

    public String name;
}

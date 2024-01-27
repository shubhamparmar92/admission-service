package com.sunrise.admissionservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Admission")
public class AdmissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int formNumber;
    public String status;
    public LocalDate applicationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    public CandidateEntity candidate;
}

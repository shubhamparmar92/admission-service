package com.sunrise.admissionservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String firstName;

    public String lastName;

    public String fatherName;

    public String dob;

    @OneToMany(cascade=CascadeType.ALL)
    public List<PhoneEntity> phoneList;

    @OneToMany(cascade=CascadeType.ALL)
    public List<AddressEntity> addressList;

    @OneToMany(cascade=CascadeType.ALL)
    public List<EmailEntity> emailList;

    public int classId;

}

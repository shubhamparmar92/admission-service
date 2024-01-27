package com.sunrise.admissionservice.repository;

import com.sunrise.admissionservice.model.AdmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository  extends JpaRepository<AdmissionEntity,Integer> {
}

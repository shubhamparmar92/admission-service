package com.sunrise.admissionservice.repository;

import com.sunrise.admissionservice.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository  extends JpaRepository<ClassEntity,Integer> {

    Optional<ClassEntity> findByName(String name);

}

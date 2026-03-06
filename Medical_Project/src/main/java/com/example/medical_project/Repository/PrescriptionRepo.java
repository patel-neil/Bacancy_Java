package com.example.medical_project.Repository;

import com.example.medical_project.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
}

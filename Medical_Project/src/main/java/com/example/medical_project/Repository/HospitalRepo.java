package com.example.medical_project.Repository;

import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Long> {
}

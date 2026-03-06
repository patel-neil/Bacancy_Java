package com.example.medical_project.Repository;

import com.example.medical_project.Entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepo extends JpaRepository<Specialization, Long> {
}

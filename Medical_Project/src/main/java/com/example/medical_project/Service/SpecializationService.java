package com.example.medical_project.Service;

import com.example.medical_project.Entity.Specialization;

import java.util.List;

public interface SpecializationService {

    Specialization createSpecialization(Specialization specialization);

    Specialization getSpecializationById(Long id);

    List<Specialization> getAllSpecializations();

    Specialization updateSpecialization(Long id, Specialization specialization);

    void deleteSpecialization(Long id);
}

package com.example.medical_project.Service.ServiceImpl;

import com.example.medical_project.Entity.Specialization;
import com.example.medical_project.Repository.SpecializationRepo;
import com.example.medical_project.Service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationRepo specializationRepo;

    @Override
    public Specialization createSpecialization(Specialization specialization) {
        return specializationRepo.save(specialization);
    }

    @Override
    public Specialization getSpecializationById(Long id) {
        return specializationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found with id: " + id));
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        return specializationRepo.findAll();
    }

    @Override
    @Transactional
    public Specialization updateSpecialization(Long id, Specialization specialization) {

        Specialization oldSpecialization = specializationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));

        oldSpecialization.setName(specialization.getName());

        return specializationRepo.save(oldSpecialization);
    }

    @Override
    public void deleteSpecialization(Long id) {

        Specialization specialization = specializationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));

        specializationRepo.delete(specialization);
    }
}

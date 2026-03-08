package com.example.medical_project.Service.ServiceImpl;

import com.example.medical_project.Entity.Patient;
import com.example.medical_project.Repository.PatientRepo;
import com.example.medical_project.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    @Transactional
    public Patient updatePatient(Long id, Patient patient) {

        Patient oldPatient = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        oldPatient.setPatientName(patient.getPatientName());
        oldPatient.setGender(patient.getGender());
        oldPatient.setDob(patient.getDob());

        return patientRepo.save(oldPatient);
    }

    @Override
    public void deletePatient(Long id) {

        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patientRepo.delete(patient);
    }
}

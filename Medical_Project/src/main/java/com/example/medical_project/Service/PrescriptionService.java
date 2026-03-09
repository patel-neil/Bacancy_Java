package com.example.medical_project.Service;

import com.example.medical_project.Entity.Prescription;

public interface PrescriptionService {
    Prescription createPrescription(Prescription prescription, Long appointmentId);

    Prescription getPrescriptionById(Long id);

    Prescription updatePrescription(Long id, Prescription prescription);

    void deletePrescription(Long id);
}

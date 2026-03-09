package com.example.medical_project.Service.ServiceImpl;

import com.example.medical_project.Entity.Appointment;
import com.example.medical_project.Entity.Prescription;
import com.example.medical_project.Repository.AppointmentRepo;
import com.example.medical_project.Repository.PrescriptionRepo;
import com.example.medical_project.Service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;
    private final AppointmentRepo appointmentRepo;

    @Override
    @Transactional
    public Prescription createPrescription(Prescription prescription, Long appointmentId) {

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        prescription.setAppointment(appointment);
        prescription.setPrescribedAt(LocalDateTime.now());

        return prescriptionRepo.save(prescription);
    }

    @Override
    public Prescription getPrescriptionById(Long id) {

        return prescriptionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

    @Override
    @Transactional
    public Prescription updatePrescription(Long id, Prescription prescription) {

        Prescription oldPrescription = prescriptionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        oldPrescription.setInstructions(prescription.getInstructions());
        oldPrescription.setPrescribedAt(prescription.getPrescribedAt());

        return prescriptionRepo.save(oldPrescription);
    }

    @Override
    public void deletePrescription(Long id) {

        Prescription prescription = prescriptionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        prescriptionRepo.delete(prescription);
    }
}

package com.example.medical_project.Controller;

import com.example.medical_project.Entity.Prescription;
import com.example.medical_project.Service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription,
                                           @RequestParam Long appointmentId) {

        return prescriptionService.createPrescription(prescription, appointmentId);
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id);
    }

    @PutMapping("/{id}")
    public Prescription updatePrescription(@PathVariable Long id,
                                           @RequestBody Prescription prescription) {

        return prescriptionService.updatePrescription(id, prescription);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
    }
}

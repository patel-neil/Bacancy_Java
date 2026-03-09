package com.example.medical_project.Controller;

import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor, @RequestParam Long hospitalId) {
        return doctorService.createDoctor(doctor, hospitalId);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor, @RequestParam Long hospitalId) {
        return doctorService.updateDoctor(id, doctor, hospitalId);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Doctor> getDoctorsByHospital(@PathVariable Long hospitalId) {
        return doctorService.getDoctorsByHospital(hospitalId);
    }
}

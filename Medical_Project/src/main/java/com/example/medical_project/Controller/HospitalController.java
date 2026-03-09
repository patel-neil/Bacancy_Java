package com.example.medical_project.Controller;

import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Entity.Hospital;
import com.example.medical_project.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalService.createHospital(hospital);
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable Long id) {
        return hospitalService.getHospitalById(id);
    }

    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @PutMapping("/{id}")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospital) {
        return hospitalService.updateHospital(id, hospital);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospitalById(id);
    }

    @GetMapping("/{id}/doctors")
    public List<Doctor> getDoctorsByHospital(@PathVariable Long id) {
        return hospitalService.getDoctorsByHospital(id);
    }
}

package com.example.medical_project.Service;

import com.example.medical_project.Entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor, Long hospitalId);

    Doctor getDoctorById(Long id);

    List<Doctor> getAllDoctors();

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);

    List<Doctor> getDoctorsByHospital(Long hospitalId);
}

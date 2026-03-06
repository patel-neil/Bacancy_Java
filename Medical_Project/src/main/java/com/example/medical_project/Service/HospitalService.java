package com.example.medical_project.Service;

import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Entity.Hospital;

import java.util.List;

public interface HospitalService {
    Hospital createHospital(Hospital hospital);

    Hospital getHospitalById(Long id);

    List<Hospital> getAllHospitals();

    Hospital updateHospital(Long id, Hospital hospital);

    void deleteHospitalById(Long id);

    List<Doctor> getDoctorsByHospital(Long id);
}

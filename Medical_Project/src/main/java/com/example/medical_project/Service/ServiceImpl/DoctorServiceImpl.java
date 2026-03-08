package com.example.medical_project.Service.ServiceImpl;

import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Entity.Hospital;
import com.example.medical_project.Repository.DoctorRepo;
import com.example.medical_project.Repository.HospitalRepo;
import com.example.medical_project.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    public Doctor createDoctor(Doctor doctor, Long hospitalId) {

        Hospital hospital = hospitalRepo.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        doctor.setHospital(hospital);

        return doctorRepo.save(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public Doctor getDoctorById(Long id) {
        return doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    @Transactional
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor oldDoctor = doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        oldDoctor.setName(doctor.getName());
        oldDoctor.setEmail(doctor.getEmail());
        oldDoctor.setPhone_number(doctor.getPhone_number());
        oldDoctor.setExperience(doctor.getExperience());

        return doctorRepo.save(oldDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctorRepo.delete(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getDoctorsByHospital(Long hospitalId) {

        if (!hospitalRepo.existsById(hospitalId)) {
            throw new RuntimeException("Hospital not found");
        }

        return doctorRepo.findByHospitalHospitalId(hospitalId);
    }
}

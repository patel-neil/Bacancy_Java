package com.example.medical_project.Service.ServiceImpl;

import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Entity.Hospital;
import com.example.medical_project.Repository.DoctorRepo;
import com.example.medical_project.Repository.HospitalRepo;
import com.example.medical_project.Service.HospitalService;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepo hospitalrepo;
    private final DoctorRepo doctorrepo;

    @Override
    public Hospital createHospital(Hospital hospital) {
        return hospitalrepo.save(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalrepo.findById(id).orElseThrow();
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalrepo.findAll();
    }

    @Transactional
    @Override
    public Hospital updateHospital(Long id, Hospital hospital) {
        Hospital oldhospital =  hospitalrepo.findById(id).orElseThrow();

        oldhospital.setHospital_name(hospital.getHospital_name());
        oldhospital.setTelephone_num(hospital.getTelephone_num());

        return hospitalrepo.save(oldhospital);
    }

    @Override
    public void deleteHospitalById(Long id) {
        Hospital hospital =  hospitalrepo.findById(id).orElseThrow();

        hospitalrepo.delete(hospital);

        System.out.println("Hospital deleted successfully");
    }

    @Override
    public List<Doctor> getDoctorsByHospital(Long id) {

        if(!hospitalrepo.existsById(id)){
            throw new RuntimeException("Hospital not found");
        }

        return doctorrepo.findByHospitalHospitalId(id);
    }
}

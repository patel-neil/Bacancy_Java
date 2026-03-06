package com.example.medical_project.Repository;

import com.example.medical_project.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    List<Doctor> findByHospitalHospitalId(Long id);
}

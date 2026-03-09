package com.example.medical_project.Service.ServiceImpl;

import com.example.medical_project.Entity.Appointment;
import com.example.medical_project.Entity.Doctor;
import com.example.medical_project.Entity.Hospital;
import com.example.medical_project.Entity.Patient;
import com.example.medical_project.Repository.AppointmentRepo;
import com.example.medical_project.Repository.DoctorRepo;
import com.example.medical_project.Repository.HospitalRepo;
import com.example.medical_project.Repository.PatientRepo;
import com.example.medical_project.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    @Transactional
    public Appointment createAppointment(Appointment appointment,
                                         Long patientId,
                                         Long doctorId,
                                         Long hospitalId) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Hospital hospital = hospitalRepo.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        appointment.setPatientId(patient);
        appointment.setDoctorId(doctor);
        appointment.setHospitalId(hospital);

        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    @Transactional
    public Appointment updateAppointment(Long id, Appointment appointment) {

        Appointment oldAppointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        oldAppointment.setAppointment_date(appointment.getAppointment_date());
        oldAppointment.setStatus(appointment.getStatus());

        return appointmentRepo.save(oldAppointment);
    }

    @Override
    @Transactional
    public void deleteAppointment(Long id) {

        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointmentRepo.delete(appointment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {

        if (!doctorRepo.existsById(doctorId)) {
            throw new RuntimeException("Doctor not found");
        }

        return appointmentRepo.findByDoctorId(doctorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByPatient(Long patientId) {

        if (!patientRepo.existsById(patientId)) {
            throw new RuntimeException("Patient not found");
        }

        return appointmentRepo.findByPatientId(patientId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByHospital(Long hospitalId) {

        if (!hospitalRepo.existsById(hospitalId)) {
            throw new RuntimeException("Hospital not found");
        }

        return appointmentRepo.findByHospitalId(hospitalId);
    }
}

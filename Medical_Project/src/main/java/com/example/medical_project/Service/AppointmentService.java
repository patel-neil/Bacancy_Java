package com.example.medical_project.Service;

import com.example.medical_project.Entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment,
                                  Long patientId,
                                  Long doctorId,
                                  Long hospitalId);

    Appointment getAppointmentById(Long id);

    List<Appointment> getAllAppointments();

    Appointment updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long id);

    List<Appointment> getAppointmentsByDoctor(Long doctorId);

    List<Appointment> getAppointmentsByPatient(Long patientId);

    List<Appointment> getAppointmentsByHospital(Long hospitalId);
}

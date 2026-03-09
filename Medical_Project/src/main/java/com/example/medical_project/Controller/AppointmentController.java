package com.example.medical_project.Controller;

import com.example.medical_project.Entity.Appointment;
import com.example.medical_project.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment,
                                         @RequestParam Long doctorId,
                                         @RequestParam Long patientId,
                                         @RequestParam Long hospitalId) {

        return appointmentService.createAppointment(appointment, doctorId, patientId, hospitalId);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id,
                                         @RequestBody Appointment appointment) {

        return appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsByDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Appointment> getAppointmentsByHospital(@PathVariable Long hospitalId) {
        return appointmentService.getAppointmentsByHospital(hospitalId);
    }
}

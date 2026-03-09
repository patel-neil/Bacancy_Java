package com.example.medical_project.Entity;


import com.example.medical_project.Enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_details")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointment_date;

    @Column(name = "appointment_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    @JsonBackReference("doctor-appointment")
    private Doctor doctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    @JsonBackReference("hospital-appointment")
    private Hospital hospitalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @JsonBackReference("patient-appointment")
    private Patient patientId;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Prescription prescription;
}

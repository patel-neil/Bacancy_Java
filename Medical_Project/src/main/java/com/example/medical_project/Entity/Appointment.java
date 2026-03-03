package com.example.medical_project.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointment_details")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate apointment_date;
}

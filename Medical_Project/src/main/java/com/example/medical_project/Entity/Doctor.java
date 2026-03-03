package com.example.medical_project.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

@Entity
@Table(name = "doctor_details")
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int Experience;

    @Column(nullable = false, length = 10, unique = true)
    private Long Phone_number;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToMany
    @JoinTable(name = "doctor_specialization_mapping",
                joinColumns = @JoinColumn(name = "doctor_id"),
                inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private HashSet<Specialization> specializations = new HashSet<>();
}

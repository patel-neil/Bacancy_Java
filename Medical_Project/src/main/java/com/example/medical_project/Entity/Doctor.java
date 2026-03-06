package com.example.medical_project.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;

    @ManyToMany
    @JoinTable(name = "doctor_specialization_mapping",
                joinColumns = @JoinColumn(name = "doctor_id"),
                inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private Set<Specialization> specializations = new HashSet<>();

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();
}

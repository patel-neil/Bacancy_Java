package com.example.medical_project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospital_details")
@Getter
@Setter
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospital_id;

    private String hospital_name;

    @Column(unique = true, length = 10)
    private Long telephone_num;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors = new ArrayList<>();
}
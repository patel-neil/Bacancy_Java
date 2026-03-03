package com.example.medical_project.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "specialization_details")
@Getter
@Setter
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spes_id;

    @Column(name = "spes_name")
    private String name;

    @ManyToMany(mappedBy = "specializations")
    private List<Doctor> doctors;
}

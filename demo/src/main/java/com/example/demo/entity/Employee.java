package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMPLOYEE_NAMES", nullable = false, length = 50)
    private String name;

    @Column(name = "EMPLOYEE_EMAILS", nullable = false,  length = 50, unique = true)
    private String email;

    @Column(name="SALARY_DETAILS", nullable = false)
    private double salary;

    @ElementCollection
    @CollectionTable(name = "EMP_HOBBIES", joinColumns = @JoinColumn(name = "id"))

    private List<String> hobbies;


    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Employee() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

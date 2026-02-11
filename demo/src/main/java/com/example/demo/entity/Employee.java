package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name ="employee_Details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Employee_names", nullable = false, length = 50)
    private String name;

    @Column(name = "employee_emails", nullable = false,  length = 50, unique = true)
    private String email;

    @Column(name="salary_details", nullable = false)
    private double salary;

    @ElementCollection
    @CollectionTable(name = "emp_hobbies", joinColumns = @JoinColumn(name = "id"))

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

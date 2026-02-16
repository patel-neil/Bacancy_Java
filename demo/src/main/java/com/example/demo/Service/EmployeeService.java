package com.example.demo.Service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);

    List<Employee> getAllEmployees();

    List<Employee> GetGreaterSalaryEmplo(double salary);

    Employee saveEmployee(Employee employee);

    Employee updateSalary(Long id, double salary);

    void deleteEmployeeById(Long id);
}

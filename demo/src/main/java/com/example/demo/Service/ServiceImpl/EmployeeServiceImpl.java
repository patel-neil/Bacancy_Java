package com.example.demo.Service.ServiceImpl;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> GetGreaterSalaryEmplo(double salary) {
        return employeeRepo.findBySalaryGreaterThan(salary);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


    @Override
    public Employee updateSalary(Long id, double salary) {
        Employee e =  employeeRepo.findById(id).orElseThrow();
        e.setSalary(salary);
        employeeRepo.save(e);
        return e;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }
}

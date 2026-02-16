package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("find/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("find")
    public List<Employee> findAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("salary/{salary}")
    public List<Employee> findBySalary(@PathVariable Double salary) {
        return employeeService.GetGreaterSalaryEmplo(salary);
    }

    @PostMapping("save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PatchMapping("update/{id}/{salary}")
    public Employee update(@PathVariable Long id, @PathVariable Double salary) {
        return employeeService.updateSalary(id,salary);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}

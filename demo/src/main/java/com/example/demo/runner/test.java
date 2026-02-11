package com.example.demo.runner;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class test  implements CommandLineRunner {

    private final EmployeeService employeeService;

    public test(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.saveEmployee(new Employee("Alice", "alice@abc.com", 50000));
        employeeService.saveEmployee(new Employee("John", "John@abc.com", 100000));
        employeeService.saveEmployee(new Employee("Jane", "Jane@abc.com", 25000));

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the threshold salary: ");
        double salary = sc.nextDouble();
        System.out.println();

        employeeService.GetGreaterSalaryEmplo(salary).forEach(System.out::println);

        employeeService.getAllEmployees().forEach(System.out::println);

        System.out.print("Please enter the id for which you want to search: ");
        Long id = sc.nextLong();
        System.out.println();

        System.out.println(employeeService.findById(id));

    }
}

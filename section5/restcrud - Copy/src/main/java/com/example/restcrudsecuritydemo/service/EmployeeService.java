package com.example.restcrudsecuritydemo.service;

import com.example.restcrudsecuritydemo.entity.Employee;

import java.util.List;

//@Service
public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}

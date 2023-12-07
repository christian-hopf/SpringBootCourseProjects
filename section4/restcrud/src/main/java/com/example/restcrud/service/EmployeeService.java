package com.example.restcrud.service;

import com.example.restcrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}

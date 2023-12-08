package com.example.restcrudsecuritydemo.dao;


import com.example.restcrudsecuritydemo.entity.Employee;

import java.util.List;

//@Repository
public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}

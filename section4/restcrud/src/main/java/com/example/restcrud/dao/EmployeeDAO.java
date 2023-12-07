package com.example.restcrud.dao;


import com.example.restcrud.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}

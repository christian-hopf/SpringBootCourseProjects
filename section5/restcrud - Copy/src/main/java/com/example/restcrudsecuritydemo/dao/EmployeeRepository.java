package com.example.restcrudsecuritydemo.dao;

import com.example.restcrudsecuritydemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

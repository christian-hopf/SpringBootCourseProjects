package com.example.restcruddatabasedemo.dao;

import com.example.restcruddatabasedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByOrderByLastNameAsc();
}

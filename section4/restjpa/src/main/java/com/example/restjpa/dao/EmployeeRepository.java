package com.example.restjpa.dao;

import com.example.restjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "/people")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

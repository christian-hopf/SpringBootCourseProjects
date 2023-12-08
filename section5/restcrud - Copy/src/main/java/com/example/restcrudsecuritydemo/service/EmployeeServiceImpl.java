package com.example.restcrudsecuritydemo.service;

import com.example.restcrudsecuritydemo.dao.EmployeeRepository;
import com.example.restcrudsecuritydemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //    private EmployeeDAO employeeDao;
    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
    }

    @Override
//    @Transactional
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}

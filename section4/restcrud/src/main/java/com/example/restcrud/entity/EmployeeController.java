package com.example.restcrud.entity;

import com.example.restcrud.dao.EmployeeDAO;
import com.example.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable(name = "id") int id) {
        Employee deletedEmployee = employeeService.findById(id);
        if (deletedEmployee == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        employeeService.deleteById(id);
        return "Deleted employee with id " + id;
    }
}

package com.example.springrestdemo.rest;

import com.example.springrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentController {

    private List<Student> students;

    // on init method
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        Student student1 = new Student("Christian", "Hopf");
        Student student2 = new Student("Scott", "Lynch");
        students.add(student1);
        students.add(student2);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if ((studentId >= students.size()) || studentId < 0) {
            // invalid id, throw exception
            throw new StudentNotFoundException("Student id " + studentId + " not found");
        }
        return students.get(studentId);
    }

}

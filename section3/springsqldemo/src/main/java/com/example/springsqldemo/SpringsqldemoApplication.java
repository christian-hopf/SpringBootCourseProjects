package com.example.springsqldemo;

import com.example.springsqldemo.dao.StudentDAO;
import com.example.springsqldemo.dao.StudentDAOImpl;
import com.example.springsqldemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringsqldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsqldemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO dao) {
        return runner -> {
//            System.out.println("bruh");
            createMultipleStudents(dao);
//            readStudent(dao);
//            queryStudents(dao);
//            queryStudentsByLastName(dao);
//            updateStudent(dao);
//            deleteStudent(dao);
//            deleteAll(dao);
        };
    }

    private void createMultipleStudents(StudentDAO dao) {
        System.out.println("Creating new students");
        Student student1 = new Student("Christian", "Hopf", "bruh@brother.com");
        Student student2 = new Student("Mike", "Mentzer", "guh@bruh.com");
        Student student3 = new Student("Steve", "Reeves", "b@buh.com");

        System.out.println("Saving students");
        dao.save(student1);
        dao.save(student2);
        dao.save(student3);

//        System.out.println("Saved student with id " + student1.getId());
    }

    private void readStudent(StudentDAO dao) {
        System.out.println("Creating new student");
        Student student1 = new Student("Read", "Student", "read@student.com");
        System.out.println("Saving student");
        dao.save(student1);
        System.out.println("Saved student with id " + student1.getId());
        System.out.println("Reading student");
        Student readStudent = dao.findById(student1.getId());
        System.out.println(readStudent.toString());
    }

    private void queryStudents(StudentDAO dao) {
        List<Student> students = dao.findAll();
        for (Student st : students) {
            System.out.println("Reading student:");
            System.out.println(st.toString());
        }
    }

    private void queryStudentsByLastName(StudentDAO dao) {
        List<Student> students = dao.findByLastName("Hopf");
        System.out.println("Reading students with last name Hopf");
        for (Student st : students) {
            System.out.println(st.toString());
        }
    }

    private void updateStudent(StudentDAO dao) {
        System.out.println("Retrieving student with id 1");
        Student student1 = dao.findById(1);
        System.out.println("Changing student email to a@b.com");
        student1.setEmail("a@b.com");
        dao.update(student1);

        System.out.println("Updated student:");
        Student updated = dao.findById(1);
        System.out.println(updated.toString());
    }

    private void deleteStudent(StudentDAO dao) {
        System.out.println("Deleting student with id 4");
        dao.delete(4);
    }

    private void deleteAll(StudentDAO dao) {
        System.out.println("Deleting all students");
        int studentsDeleted = dao.deleteAll();
        System.out.println("Number of students deleted: " + studentsDeleted);
    }

}

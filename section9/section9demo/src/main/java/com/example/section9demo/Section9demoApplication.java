package com.example.section9demo;

import com.example.section9demo.dao.AppDAO;
import com.example.section9demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Section9demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Section9demoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO dao) {
        return runner -> {
//            System.out.println("hello");
//            createInstructor(dao);
//            findInstructor(dao);
//            deleteInstructor(dao);
//            findInstructorDetail(dao);
//            deleteInstructorDetail(dao);
//            createInstructorWithCourses(dao);
//            findInstructorWithCourses(dao);
//            findCoursesByInstructor(dao);
//            findInstructorWithCoursesJoinFetch(dao);
//            updateInstructor(dao);
//            updateCourse(dao);
//            deleteCourse(dao);
//            createCourseWithReviews(dao);
//            findCourseAndReviews(dao);
//            deleteCourseAndReviews(dao);
//            createCourseWithStudents(dao);
//            findCourseAndStudents(dao);
//            findStudentAndCourses(dao);
//            updateStudent(dao);
            deleteStudent(dao);
        };
    }

    private void createInstructor(AppDAO dao) {
//        Instructor instructor = new Instructor("Christian", "Hopf", "b@bruh.com");
//        InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Reading");
        Instructor instructor = new Instructor("Test", "Instructor", "b@bruh.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Testing");
        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving instructor");
        dao.save(instructor);
        System.out.println("Saved instructor");
    }

    private void findInstructor(AppDAO dao) {
        int id = 2;
        System.out.println("Finding instructor with id " + id);
        Instructor result = dao.findInstructorById(id);
        System.out.println("Found instructor with id " + id);
        System.out.println("Instructor: " + result);
        System.out.println("InstructorDetail: " + result.getInstructorDetail());
    }

    private void deleteInstructor(AppDAO dao) {
        System.out.println("Deleting instructor with id " + 1);
        dao.deleteInstructorById(1);
        System.out.println("Instructor with id " + 1 + " deleted");
    }

    private void findInstructorDetail(AppDAO dao) {
        System.out.println("Finding instructor detail with id " + 2);
        InstructorDetail result = dao.findInstructorDetailById(2);
        System.out.println("Found instructor detail with id " + 2);
        System.out.println("InstructorDetail: " + result);
        System.out.println("Instructor: " + result.getInstructor());
    }

    private void deleteInstructorDetail(AppDAO dao) {
        System.out.println("Deleting instructor detail with id " + 4);
        dao.deleteInstructorDetailById(4);
        System.out.println("Instructor detail with id " + 4 + " deleted");
    }

    private void createInstructorWithCourses(AppDAO dao) {
        Instructor instructor = new Instructor("Test", "Instructor", "b@bruh.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Testing");
        instructor.setInstructorDetail(instructorDetail);

        Course course1 = new Course("Calculus");
        Course course2 = new Course("Reading 101");
        instructor.addCourse(course1);
        instructor.addCourse(course2);

        System.out.println("Saving instructor");
        dao.save(instructor);
        System.out.println("Saved instructor");
    }

    private void findInstructorWithCourses(AppDAO dao) {
        int id = 1;
        System.out.println("Finding instructor with id " + id);
        Instructor result = dao.findInstructorById(id);
        System.out.println("Found instructor with id " + id);
        System.out.println("Instructor: " + result);
        System.out.println("Instructor courses: " + result.getCourses());
    }

    private void findCoursesByInstructor(AppDAO dao) {
        int id = 1;
        System.out.println("Finding courses with instructor id " + id);
        List<Course> courses = dao.findCoursesByInstructorId(id);
        System.out.println("Found courses with instructor id " + id);
        System.out.println("Instructor courses: " + courses);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO dao) {
        int id = 1;
        System.out.println("Finding instructor with id " + id);
        Instructor result = dao.findInstructorByIdJoinFetch(id);
        System.out.println("Instructor: " + result);
        System.out.println("Instructor courses: " + result.getCourses());
    }

    private void updateInstructor(AppDAO dao) {
        int id = 1;
        System.out.println("Finding instructor with id " + id);
        Instructor result = dao.findInstructorByIdJoinFetch(id);
        System.out.println("Found instructor, updating instructor with id " + id);
        result.setLastName("User");
        dao.update(result);
        System.out.println("Updated instructor with id " + id);
    }

    private void updateCourse(AppDAO dao) {
        int id = 10;
        System.out.println("Finding course with id " + id);
        Course course = dao.findCourseById(id);
        System.out.println("Updating course with id " + id);
        course.setTitle("Calculus 2");
        dao.update(course);
        System.out.println("Updated course with id " + id);
    }

    private void deleteCourse(AppDAO dao) {
        int id = 10;
        System.out.println("Deleting course with id " + id);
        dao.deleteCourseById(id);
        System.out.println("Deleted course with id " + id);
    }

    private void createCourseWithReviews(AppDAO dao) {
        Course course3 = new Course("Japanese 101");
        course3.addReview(new Review("Great course"));
        course3.addReview(new Review("Awesome course"));
        course3.addReview(new Review("My favorite course"));
        System.out.println("Saving course with reviews: " + course3.getReviews());
        dao.save(course3);
        System.out.println("Saved course with reviews");
    }

    private void findCourseAndReviews(AppDAO dao) {
        int id = 11;
        System.out.println("Finding course and reviews with course id " + id);
        Course course = dao.findCourseAndReviewsByCourseId(id);
        System.out.println("Course: " + course);
        System.out.println("Reviews: " + course.getReviews());
    }

    private void deleteCourseAndReviews(AppDAO dao) {
        int id = 11;
        System.out.println("Deleting course and reviews with id " + id);
        dao.deleteCourseById(id);
        System.out.println("Deleted course with id " + id);
    }

    private void createCourseWithStudents(AppDAO dao) {
        Course course1 = new Course("Firearm Safety");
        Student student1 = new Student("A", "B", "e@email.com");
        Student student2 = new Student("C", "D", "e@email.com");
        Student student3 = new Student("E", "F", "e@email.com");
        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);
        System.out.println("Saving course: " + course1);
        System.out.println("Associated students: " + course1.getStudents());
        dao.save(course1);
        System.out.println("Course saved");
    }

    private void findCourseAndStudents(AppDAO dao) {
        int id = 10;
        System.out.println("Finding course and associated students with course id " + id);
        Course course = dao.findCourseAndStudentsByCourseId(id);
        System.out.println("Course: " + course);
        System.out.println("Students: " + course.getStudents());
    }

    private void findStudentAndCourses(AppDAO dao) {
        int id = 1;
        System.out.println("Finding student and associated courses with student id " + id);
        Student student = dao.findStudentAndCoursesByStudentId(id);
        System.out.println("Student: " + student);
        System.out.println("Courses: " + student.getCourses());
    }

    private void updateStudent(AppDAO dao) {
        int id = 3;
        Student student = dao.findStudentAndCoursesByStudentId(3);
        System.out.println("Adding courses to student with id " + id);
        Course course1 = new Course("Java");
        Course course2 = new Course("Baking");
        student.addCourse(course1);
        student.addCourse(course2);
        dao.update(student);
        System.out.println("Updated student with id " + id);
    }

    private void deleteStudent(AppDAO dao) {
        int id = 1;
        System.out.println("Deleting student with id " + id);
        dao.deleteStudentById(id);
        System.out.println("Deleted student with id " + id);
    }

}

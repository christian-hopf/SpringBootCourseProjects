package com.example.section9demo.dao;

import com.example.section9demo.entity.Course;
import com.example.section9demo.entity.Instructor;
import com.example.section9demo.entity.InstructorDetail;
import com.example.section9demo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    void save(Course course);

    Instructor findInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Course findCourseById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Instructor instructor);

    void update(Course course);

    void update(Student student);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);

    void deleteCourseById(int id);

    void deleteStudentById(int id);

}

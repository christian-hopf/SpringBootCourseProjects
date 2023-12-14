package com.example.section9demo.dao;

import com.example.section9demo.entity.Course;
import com.example.section9demo.entity.Instructor;
import com.example.section9demo.entity.InstructorDetail;

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

    void update(Instructor instructor);

    void update(Course course);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);

    void deleteCourseById(int id);

}

package com.example.vstu_project.services;

import com.example.vstu_project.entity.Courses;

import java.util.List;

public interface EmployeeService {

    StringBuffer getFullName(Long id);

    List<Courses> getAllCourses();

    void deleteCourses(Long id);

    void createCourse(Courses course);
}

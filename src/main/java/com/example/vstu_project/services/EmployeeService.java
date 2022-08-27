package com.example.vstu_project.services;

import com.example.vstu_project.dto.CategoriesCheckboxDTO;
import com.example.vstu_project.entity.Courses;
//import com.example.vstu_project.entity.StudentCourse;

import java.util.List;

public interface EmployeeService {

    StringBuffer getFullName(Long id);

    List<Courses> getAllCourses();

    void deleteCourses(Long id);

    void createCourse(Courses course, CategoriesCheckboxDTO categoriesCheckboxDTO);

//    StudentCourse getStudentCourse(String number_course);

}

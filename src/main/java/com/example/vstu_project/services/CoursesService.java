package com.example.vstu_project.services;

import com.example.vstu_project.entity.Category;
import com.example.vstu_project.entity.Courses;

import java.util.List;

public interface CoursesService {

    List<Courses> getAllCourses();

    void delete(Long id);

    void create(Courses course);
}

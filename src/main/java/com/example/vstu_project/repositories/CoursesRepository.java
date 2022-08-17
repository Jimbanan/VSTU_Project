package com.example.vstu_project.repositories;

import com.example.vstu_project.entity.Courses;
import com.example.vstu_project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {



}

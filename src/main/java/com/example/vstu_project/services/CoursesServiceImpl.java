package com.example.vstu_project.services;

import com.example.vstu_project.entity.Courses;
import com.example.vstu_project.repositories.CoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        coursesRepository.deleteById(id);
    }

    @Override
    public void create(Courses course) {

        //TODO - Доделать (Сделать репозиторий для StudentCourse для временной заглушки)
        course.setCategories(null);

        coursesRepository.save(course);
    }

}

package com.example.vstu_project.services;

import com.example.vstu_project.entity.Courses;
import com.example.vstu_project.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final UsersServicesImpl usersServices;
    private final CoursesServiceImpl coursesService;

    public StringBuffer getFullName(Long id) {

        Users user = usersServices.findUserById(id);

        StringBuffer fullName = new StringBuffer();

        return fullName.append(user.getSurname())
                .append(" ")
                .append(user.getName().charAt(0))
                .append(".")
                .append(user.getPatronymic().charAt(0))
                .append(".");
    }

    public List<Courses> getAllCourses() {

        //TODO - Сделать вывод по дате
        //TODO - СДелать сортировку по дате

        return coursesService.getAllCourses()
                .stream()
                .sorted(Comparator.comparing(Courses::getDateTime)
                        .thenComparing(Courses::getName))
                .filter(courses -> courses.getDateTime().isAfter(LocalDateTime.now()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}

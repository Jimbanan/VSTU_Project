package com.example.vstu_project.services;

import com.example.vstu_project.dto.CategoriesCheckboxDTO;
import com.example.vstu_project.entity.Categories;
import com.example.vstu_project.entity.Courses;
//import com.example.vstu_project.entity.StudentCourse;
import com.example.vstu_project.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final UsersServicesImpl usersServices;
    private final CoursesServiceImpl coursesService;
    private final ImageServiceImpl imageService;

//    private final StudentCourseServiceImpl studentCourseService;

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
        return coursesService.getAllCourses()
                .stream()
                .sorted(Comparator.comparing(Courses::getDateTime)
                        .thenComparing(Courses::getName))
                .filter(courses -> courses.getDateTime().isAfter(LocalDateTime.now()))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public Users getUser(Long id) {
        return usersServices.findUserById(id);
    }

    public void deleteCourses(Long id) {
        coursesService.delete(id);
    }

    @Override
    public void createCourse(Courses course, CategoriesCheckboxDTO categoriesCheckboxDTO) {

        List<Categories> categoriesList = new ArrayList<>();

        for (int i = 0; i < categoriesCheckboxDTO.getCategoriesArrayList().size(); i++) {
            categoriesList.add(Categories.builder()
                    .categories(categoriesCheckboxDTO.getCategoriesArrayList().get(i).toString())
                    .build());
        }

        course.setCategories(categoriesList);

        coursesService.create(course);

    }

//    @Override
//    public StudentCourse getStudentCourse(String number_course) {
//        return studentCourseService.findStudentCourse(number_course);
//    }

    public String uploadFile(MultipartFile file) {
        return imageService.loadNewFile(file);
    }

}

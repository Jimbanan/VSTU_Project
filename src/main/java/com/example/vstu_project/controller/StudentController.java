package com.example.vstu_project.controller;

import com.example.vstu_project.services.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"UserIDRegistrationController", "fullNameUser"})
@RequestMapping("/student")
public class StudentController {

    //TODO - Проверить структуру папок при импорте изображений для каждого html
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/main")
    public String mainPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", studentService.getFullName(id));//Получение полного имени пользователя

        model.addAttribute("courses", studentService.getAllCourses());//Получение всех курсов

        model.addAttribute("UserIDRegistrationController", id);

        return "student_main_page";
    }

    @RequestMapping("/calendar")
    public String calendarPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        return "student_calendar";
    }

    @RequestMapping("/my_events")
    public String myEventsPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        return "student_my_events";
    }

    @RequestMapping("/settings")
    public String settingsPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", studentService.getFullName(id));

        model.addAttribute("userData", studentService.getUser(id));

        return "student_settings";
    }

}

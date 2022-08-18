package com.example.vstu_project.controllers;

import com.example.vstu_project.entity.Courses;
import com.example.vstu_project.services.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes(value = "UserIDRegistrationController")
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/main")
    public String mainPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", employeeService.getFullName(id));//Получение полного имени пользователя

        model.addAttribute("courses", employeeService.getAllCourses());//Получение всех курсов

        model.addAttribute("UserIDRegistrationController", id);//Добавление ID пользователя в сессию

        return "employee_main_page";
    }

    @RequestMapping("/lists_of_participants")
    public String listsOfParticipantsPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", employeeService.getFullName(id));

        return "employee_lists_of_participants";
    }

    @RequestMapping("/event_management")
    public String eventManagementPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", employeeService.getFullName(id));

        return "employee_event_management";
    }


}

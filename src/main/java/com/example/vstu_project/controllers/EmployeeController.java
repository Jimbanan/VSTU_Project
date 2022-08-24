package com.example.vstu_project.controllers;

import com.example.vstu_project.entity.Courses;
import com.example.vstu_project.services.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        model.addAttribute("courses", employeeService.getAllCourses());//Получение всех курсов

        return "employee_lists_of_participants";
    }

    @RequestMapping("/event_management")
    public String eventManagementPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", employeeService.getFullName(id));

        model.addAttribute("courses", employeeService.getAllCourses());//Получение всех курсов


        return "employee_event_management";
    }

    @RequestMapping(value = "/event_management/create", method = RequestMethod.GET)
    public String employee_event_management_createPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", employeeService.getFullName(id));

        model.addAttribute("newCourse", new Courses());

        return "employee_event_management_create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create( @ModelAttribute(value = "newCourse") Courses course) {



        employeeService.createCourse(course);

        return "redirect:/employee/event_management";
    }

    @RequestMapping(value = "/event_management/{id}/deleteCourse", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "id") Long id) {

        employeeService.deleteCourses(id);

        return "redirect:/employee/event_management";
    }

    @RequestMapping("/settings")
    public String settingsPage(@ModelAttribute("UserIDRegistrationController") Long id, Model model) {

        model.addAttribute("fullNameUser", employeeService.getFullName(id));

        model.addAttribute("userData", employeeService.getUser(id));

        return "employee_settings";
    }


}

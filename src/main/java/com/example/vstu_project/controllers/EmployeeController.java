package com.example.vstu_project.controllers;

import com.example.vstu_project.services.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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

        model.addAttribute("fullNameUser", employeeService.getFullName(id));
        model.addAttribute("UserIDRegistrationController", id);

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

package com.example.vstu_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/main")
    public String mainPage() {
        return "employee_main_page";
    }

    @RequestMapping("/lists_of_participants")
    public String listsOfParticipantsPage() {
        return "employee_lists_of_participants";
    }

    @RequestMapping("/event_management")
    public String eventManagementPage() {
        return "employee_event_management";
    }


}

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

}

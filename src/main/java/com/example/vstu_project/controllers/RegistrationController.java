package com.example.vstu_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistrationController {

    @GetMapping("/authorization")
    public String authorizationPage(Model model) {
        return "authorization";
    }

    @GetMapping("/registration_employee")
    public String registration_employeePage(Model model) {
        return "registration_employee";
    }

}

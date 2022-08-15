package com.example.vstu_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/main")
    public String mainPage() {
        return "student_main_page";
    }

    @RequestMapping("/calendar")
    public String calendarPage() {
        return "student_calendar";
    }

}

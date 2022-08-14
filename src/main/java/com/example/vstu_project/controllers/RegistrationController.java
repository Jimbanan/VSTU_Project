package com.example.vstu_project.controllers;

import com.example.vstu_project.dto.AuthorizationDTO;
import com.example.vstu_project.entity.Users;
import com.example.vstu_project.services.AuthorizationServicesImpl;
import com.example.vstu_project.services.RegistrationServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegistrationController {

    private final RegistrationServicesImpl registrationServices;
    private final AuthorizationServicesImpl authorizationServices;

    public RegistrationController(RegistrationServicesImpl registrationServices, AuthorizationServicesImpl authorizationServices) {
        this.registrationServices = registrationServices;
        this.authorizationServices = authorizationServices;
    }

    @GetMapping("/authorization")
    public String authorizationPage(Model model) {
        model.addAttribute("authorizationDTO", new AuthorizationDTO());
        return "authorization";
    }

    @PostMapping("/authorization")
    public String findUser(@ModelAttribute("authorizationDTO") AuthorizationDTO authorizationDTO) {

        Users users = authorizationServices.findUser(authorizationDTO);

        //TODO Сделать проверку по ролям и сделать соответствующий редирект

        return "redirect:/authorization";
    }

    @RequestMapping("/registration_employee")
    public String registration_employeePage(Model model) {
        model.addAttribute("user", new Users());
        return "registration_employee";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") Users users) {

        //TODO - сделать select в регистрации.html через таймлиф и enums
        switch (users.getDivision()) {
            case "1":
                users.setDivision("Деканат");
            case "2":
                users.setDivision("Кафедра");
            case "3":
                users.setDivision("Аспирантура");
        }
        registrationServices.addUser(users);
        return "redirect:/authorization";
    }

}

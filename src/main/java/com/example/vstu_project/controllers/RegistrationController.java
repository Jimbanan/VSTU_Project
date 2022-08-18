package com.example.vstu_project.controllers;

import com.example.vstu_project.dto.AuthorizationDTO;
import com.example.vstu_project.entity.Users;
import com.example.vstu_project.enums.Division;
import com.example.vstu_project.services.AuthorizationServicesImpl;
import com.example.vstu_project.services.RegistrationServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String findUser(@ModelAttribute("authorizationDTO") AuthorizationDTO authorizationDTO,
                           final RedirectAttributes redirectAttributes) {

        Users users = authorizationServices.findUser(authorizationDTO);
        if (users != null) {
            if (users.getDivision().equals(Division.STUDENT.getDisplayValue())) {
                redirectAttributes.addFlashAttribute("UserIDRegistrationController", users.getId());
                return "redirect:/student/main";
            } else {
                redirectAttributes.addFlashAttribute("UserIDRegistrationController", users.getId());
                return "redirect:/employee/main";
            }
        } else {
            //TODO - Сделать вывод ошибки при отсутствующем аккаунте
            return "redirect:/authorization";
        }


    }

    @RequestMapping("/registration_employee")
    public String registration_employeePage(Model model) {
        model.addAttribute("user", new Users());
        return "registration_employee";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") Users users) {

        System.out.println(users.getDivision());
        //TODO - сделать select в регистрации.html через таймлиф и enums
        switch (users.getDivision()) {
            case "1":
                users.setDivision(Division.STUDENT.getDisplayValue());
                break;
            case "2":
                users.setDivision(Division.DEANERY.getDisplayValue());
                break;
            case "3":
                users.setDivision(Division.CHAIR.getDisplayValue());
                break;
            case "4":
                users.setDivision(Division.PHD.getDisplayValue());
                break;
        }


        registrationServices.addUser(users);
        return "redirect:/authorization";
    }

}

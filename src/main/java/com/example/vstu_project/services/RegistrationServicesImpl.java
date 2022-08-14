package com.example.vstu_project.services;

import com.example.vstu_project.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServicesImpl implements RegistrationServices {

    private final UsersServicesImpl usersServices;

    public void addUser(Users users) {
        usersServices.addUser(users);
    }

}

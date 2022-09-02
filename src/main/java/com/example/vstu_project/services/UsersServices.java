package com.example.vstu_project.services;

import com.example.vstu_project.dto.AuthorizationDTO;
import com.example.vstu_project.entity.Users;

public interface UsersServices {

    void addUser(Users users);

    Users findUser(AuthorizationDTO authorizationDTO);

    Users findUserById(Long id);

}

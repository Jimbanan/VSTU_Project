package com.example.vstu_project.services;

import com.example.vstu_project.dto.AuthorizationDTO;
import com.example.vstu_project.entity.Users;

public interface AuthorizationServices {

    Users findUser(AuthorizationDTO authorizationDTO);

}

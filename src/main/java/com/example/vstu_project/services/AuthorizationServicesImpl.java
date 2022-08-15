package com.example.vstu_project.services;

import com.example.vstu_project.dto.AuthorizationDTO;
import com.example.vstu_project.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServicesImpl implements AuthorizationServices {

    private final UsersServicesImpl usersServices;

    public Users findUser(AuthorizationDTO authorizationDTO) {
        return usersServices.findUser(authorizationDTO);
    }

}

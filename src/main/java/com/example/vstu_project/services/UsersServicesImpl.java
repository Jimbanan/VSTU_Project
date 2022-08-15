package com.example.vstu_project.services;

import com.example.vstu_project.dto.AuthorizationDTO;
import com.example.vstu_project.entity.Users;
import com.example.vstu_project.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServicesImpl implements UsersServices {

    private final UsersRepository usersRepository;

    public void addUser(Users users) {
        usersRepository.save(users);
    }

    public Users findUser(AuthorizationDTO authorizationDTO) {
        return usersRepository.findByEmailAndPassword(authorizationDTO.getEmail(), authorizationDTO.getPassword());
    }

}

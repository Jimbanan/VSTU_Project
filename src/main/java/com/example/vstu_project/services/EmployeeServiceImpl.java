package com.example.vstu_project.services;

import com.example.vstu_project.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final UsersServicesImpl usersServices;

    public StringBuffer getFullName(Long id) {

        Users user = usersServices.findUserById(id);

        StringBuffer fullName = new StringBuffer();

        return fullName.append(user.getSurname())
                .append(" ")
                .append(user.getName().charAt(0))
                .append(".")
                .append(user.getPatronymic().charAt(0))
                .append(".");
    }

}

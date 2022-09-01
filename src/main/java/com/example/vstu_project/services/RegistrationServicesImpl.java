package com.example.vstu_project.services;

import com.example.vstu_project.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServicesImpl implements RegistrationServices {

    private final UsersServicesImpl usersServices;
    private final MailSenderServiceImpl mailSender;

    public void addUser(Users users) {
        usersServices.addUser(users);
    }

    @Override
    public void sendEmail(Users user) {
        StringBuilder sb = new StringBuilder();
        sb.append("Здравствуйте!").append("\n")
                .append(user.getName()).append(" ").append("вы успешно зарегистрировались на портале ВГТУ для отслеживания мероприятий").append("\n")
                .append("Ваши данные для авторизации").append("\n")
                .append("Логин: ").append(user.getEmail()).append("\n")
                .append("Пароль: ").append(user.getPassword()).append("\n");

        mailSender.sendEmail(user.getEmail(), "Регистрация успешно завершена", sb.toString());
    }

}

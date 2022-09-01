package com.example.vstu_project.services;

public interface MailSenderService {

    void sendEmail(String to, String subject, String text);

}

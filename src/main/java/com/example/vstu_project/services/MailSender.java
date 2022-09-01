package com.example.vstu_project.services;

public interface MailSender {

    void sendEmail(String to, String subject, String text);

}

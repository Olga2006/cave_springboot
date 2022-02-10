package com.orb.caveweb.services;

//import com.cave.beans.Erreur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public Boolean sendEmail(String[] recipients, String[] bccRecipients, String subject, String message) throws MessagingException, IOException {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recipients);
        msg.setBcc(bccRecipients);
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
        return true;
    }
}



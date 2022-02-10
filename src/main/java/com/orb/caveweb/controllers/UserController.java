package com.orb.caveweb.controllers;

import com.orb.caveweb.dao.entity.Utilisateur;
import com.orb.caveweb.services.MailService;
import com.orb.caveweb.services.UserService;
import com.orb.caveweb.tools.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @ResponseBody
    @GetMapping(path = "/login/{email}/{motDePasse}")
    public ResponseEntity<Utilisateur> getUser(@PathVariable String email, @PathVariable String motDePasse) {
        Utilisateur user = userService.getConnectedUserByEmail(email);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.ERR_EMAIL_NOT_FOUND);
        }
        if (!user.getMotDePasse().equals(motDePasse)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.ERR_INVALID_PASSWORD);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/postUser")
    public Utilisateur saveUser(@RequestBody Utilisateur utilisateur) {

        Utilisateur existedUser = userService.getConnectedUserByEmail(utilisateur.getEmail());
        if (existedUser != null && !utilisateur.getId().equals(existedUser.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.ERR_EMAIL_EXISTS);
        }
        return userService.saveUser(utilisateur);
    }

    @PostMapping("/sendPassword/{email}")
    public Boolean sendPassword(@PathVariable String email) {
        Utilisateur user = userService.getConnectedUserByEmail(email);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.ERR_EMAIL_NOT_FOUND);
        }

        String[] recipients = new String[]{user.getEmail()};
        String[] bccRecipients = new String[]{"olga20reba@gmail.com"};
        String subject = "Mail from, caveWeb support mail ";
        String messageBody = "Bonjour " + user.getNom() + "\n" + "\n" +
                "Vous avez demandé à vous envoyer  du mot de passe de votre compte CaveWeb." + "\n" + "\n" +
                "Votre mot de passe : " + user.getMotDePasse() + "\n" + "\n" +
                "Lorsque vous êtes connecté à votre compte, vous pouvez modifier votre mot de passe en cliquant sur le bouton «Mettre à jour» dans le menu principal." + "\n" + "\n" +
                "À très bientôt. \n" +
                "L’équipe CaveWeb.";
        Boolean isSended;
        try {
            isSended = mailService.sendEmail(recipients, bccRecipients, subject, messageBody);
        } catch (MessagingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Const.KO);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Const.KO);
        }
       if (!isSended){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.KO);
        }
        return true;
    }


    @DeleteMapping("/delUser/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }
}

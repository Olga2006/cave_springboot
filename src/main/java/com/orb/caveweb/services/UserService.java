package com.orb.caveweb.services;

import com.orb.caveweb.dao.entity.Utilisateur;

import java.util.Optional;

public interface UserService {

    Utilisateur getConnectedUserByEmail(String email);

    Utilisateur saveUser(Utilisateur utilisateur);

    void deleteById(Integer id);

}

package com.orb.caveweb.services.impl;

import com.orb.caveweb.dao.UserRepository;
import com.orb.caveweb.dao.entity.Utilisateur;
import com.orb.caveweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;


    @Override
    public Utilisateur getConnectedUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Utilisateur saveUser(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}

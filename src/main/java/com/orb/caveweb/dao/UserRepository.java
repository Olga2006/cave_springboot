package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Utilisateur, Integer> {

    Utilisateur findByEmail(String email);

}

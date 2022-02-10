package com.orb.caveweb.services.impl;

import com.orb.caveweb.dao.ErreurRepository;
import com.orb.caveweb.dao.entity.Erreur;
import com.orb.caveweb.services.ErreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErreurServiceImpl implements ErreurService {

    @Autowired
    public ErreurRepository erreurRepository;

    @Override
    public Iterable<Erreur> getListeErreurs() {
        return erreurRepository.findAll();
    }

    @Override
    public Erreur saveErreur(Erreur erreur) {
        return erreurRepository.save(erreur);
    }

    @Override
    public void deleteById(Integer id) {
        erreurRepository.deleteById(id);

    }
}

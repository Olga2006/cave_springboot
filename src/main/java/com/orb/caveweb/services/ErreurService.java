package com.orb.caveweb.services;

import com.orb.caveweb.dao.entity.Erreur;

public interface ErreurService {

    Iterable<Erreur> getListeErreurs();

    Erreur saveErreur(Erreur erreur);

    void deleteById(Integer id);

}

package com.orb.caveweb.services;

import com.orb.caveweb.dao.entity.Producteur;

import java.util.List;
import java.util.Optional;

public interface ProducerService {

    List<Producteur> getListeUserProducers(Integer idUser);

    //Iterable<Producteur> getListeCommonProducers(Integer idUser);

    Iterable<Producteur> getListeCommonProducers(Integer idUser);

    Optional<Producteur> getProducerById(Integer id);

    Producteur saveProducer(Producteur producteur);

    void deleteById(Integer id);

}

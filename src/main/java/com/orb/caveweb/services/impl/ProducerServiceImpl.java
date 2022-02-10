package com.orb.caveweb.services.impl;

import com.orb.caveweb.dao.ProducerRepository;
import com.orb.caveweb.dao.entity.Producteur;
import com.orb.caveweb.services.ProducerService;
import com.orb.caveweb.tools.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    public ProducerRepository producerRepository;

    @Override
    public List<Producteur> getListeUserProducers(Integer idUser) {
        return producerRepository.findByIdUtilisateur(idUser);
    }

    @Override
    public Iterable<Producteur> getListeCommonProducers(Integer idUser) {
        //return producerAPIDAO.findByIdUtilisateurNotAndIsAllowedCL(idUser, true);
        return producerRepository.findByIdUtilisateurNotAndIsPayedNative(Const.PAID_TO_COMMON_LIST ,idUser);
    }

    @Override
    public Optional<Producteur> getProducerById(Integer id) {
        return producerRepository.findById(id);
    }

    @Override
    public Producteur saveProducer(Producteur producteur) {
        return producerRepository.save(producteur);
    }

    @Override
    public void deleteById(Integer id) {
        producerRepository.deleteById(id);
    }
}

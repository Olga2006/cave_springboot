package com.orb.caveweb.controllers;

import com.orb.caveweb.dao.entity.Producteur;
import com.orb.caveweb.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/producers")
@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping(path = "/userProducers/{idUser}")
    public List<Producteur> getListeUserProducers(@PathVariable Integer idUser) {

        return producerService.getListeUserProducers(idUser);
    }

    @GetMapping(path = "/commonProducers/{idUser}")
    public Iterable<Producteur> getListeCommonProducers(@PathVariable Integer idUser) {
        return producerService.getListeCommonProducers(idUser);
    }

    @GetMapping(path = "/getProducer/{id}")
    public Optional<Producteur> getProducer(@PathVariable Integer id) {
        return producerService.getProducerById(id);
    }

    @PostMapping("/postProducer")
    public Producteur saveProducer(@RequestBody Producteur producteur) {
        return producerService.saveProducer(producteur);
    }

    @DeleteMapping("/delProducer/{id}")
    void deleteProducer(@PathVariable Integer id) {
        producerService.deleteById(id);
    }

}

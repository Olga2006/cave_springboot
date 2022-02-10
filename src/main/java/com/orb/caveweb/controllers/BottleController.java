package com.orb.caveweb.controllers;

import com.orb.caveweb.dao.entity.Bouteille;
import com.orb.caveweb.dao.entity.BouteilleGet;
import com.orb.caveweb.dao.entity.Image;
import com.orb.caveweb.services.BottleService;
import com.orb.caveweb.tools.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/bottles")
@RestController
public class BottleController {

    @Autowired
    private BottleService bottleService;

    @GetMapping(path = "/userBottles/{idUser}")
    public List<BouteilleGet> getListeUserBottles(@PathVariable Integer idUser) {
        List<BouteilleGet> lb = bottleService.getListeUserBottles(idUser);
        return lb;
    }

    @GetMapping(path = "/commonBottles/{idUser}")
    public List<BouteilleGet> getListeCommonBottles(@PathVariable Integer idUser) {
        List<BouteilleGet> lb = bottleService.getListeCommonBottles(idUser);
        return lb;
    }

    @PostMapping("/postBottle")
    public BouteilleGet saveBottle(@RequestBody Bouteille bouteille, Image image) {
        BouteilleGet b = bottleService.saveBottle(bouteille, image.getUrl());
        return b;
    }

    @PostMapping("/copyBottle/{idUser}")
    public BouteilleGet copyBottle(@PathVariable Integer idUser,
                                   @RequestBody BouteilleGet bouteille) {
        BouteilleGet b = null;
        try{
            b = bottleService.copyBottle(bouteille, idUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.ERR_EXISTS);
        }
        return b;
    }

    @DeleteMapping("/delBottle/{idBouteille}/{idUser}")
    void deleteBottle(@PathVariable Integer idBouteille, @PathVariable Integer idUser, @RequestBody Image image) {
        bottleService.deleteById(idBouteille, idUser, image.getUrl());
    }

}

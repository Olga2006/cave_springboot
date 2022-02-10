package com.orb.caveweb.services;

import com.orb.caveweb.dao.entity.Bouteille;
import com.orb.caveweb.dao.entity.BouteilleGet;

import java.util.List;

public interface BottleService {

    List<BouteilleGet> getListeUserBottles(Integer idUser);

    List<BouteilleGet> getListeCommonBottles(Integer idUser);

    BouteilleGet saveBottle(Bouteille bouteille, String imgToDel);

    void deleteById(Integer idBouteille, Integer idUser, String imgUrl);

    BouteilleGet copyBottle(BouteilleGet bouteille, Integer idUser);
}

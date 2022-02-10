package com.orb.caveweb.services;

import com.orb.caveweb.dao.entity.Cave;
import com.orb.caveweb.dao.entity.CaveFull;
import com.orb.caveweb.dao.entity.CaveGet;

import java.util.List;
import java.util.Optional;

public interface CellarService {

    List<CaveGet> getListeUserCaves(Integer idUser);

    Optional<CaveFull> getCaveFull(Integer idCellar);

    Cave saveCave(Cave cave);

    void deleteById(Integer id);
}

package com.orb.caveweb.services;

import com.orb.caveweb.dao.entity.PositionsGet;

import java.util.List;

public interface PositionService {

    List<PositionsGet> getListeBottlePositions(Integer idBouteille);

    void deleteById(Integer id);

}

package com.orb.caveweb.services.impl;

import com.orb.caveweb.dao.PositionsGetRepository;
import com.orb.caveweb.dao.entity.PositionsGet;
import com.orb.caveweb.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    public PositionsGetRepository positionsGetRepository;

    @Override
    public List<PositionsGet> getListeBottlePositions(Integer idBouteille) {
        return positionsGetRepository.findByIdBouteilleNative(idBouteille);
    }

    @Override
    public void deleteById(Integer id) {
        positionsGetRepository.deleteById(id);
    }


}

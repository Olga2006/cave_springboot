package com.orb.caveweb.services.impl;

import com.orb.caveweb.dao.CellarFullRepository;
import com.orb.caveweb.dao.CellarGetRepository;
import com.orb.caveweb.dao.CellarRepository;
import com.orb.caveweb.dao.entity.Cave;
import com.orb.caveweb.dao.entity.CaveFull;
import com.orb.caveweb.dao.entity.CaveGet;
import com.orb.caveweb.services.CellarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CellarServiceImpl implements CellarService {

    public static final String PAGE = "CaveService";

    @Autowired
    public CellarRepository cellarRepository;

    @Autowired
    public CellarGetRepository cellarGetRepository;

    @Autowired
    public CellarFullRepository cellarFullRepository;


    @Override
    public List<CaveGet> getListeUserCaves(Integer idUser) {
        List<Integer> listIdsCaves = cellarRepository.getListIdsNative(idUser);
        List<CaveGet> listCaves = new ArrayList<>();
        listIdsCaves.forEach(id -> listCaves.add(cellarGetRepository.findByIdCaveNative(id)));
        return listCaves;
    }

    @Override
    public Optional<CaveFull> getCaveFull(Integer idCellar) {
        return cellarFullRepository.findById(idCellar);
    }

    @Override
    public Cave saveCave(Cave cave) {
        return cellarRepository.save(cave);
    }

    @Override
    public void deleteById(Integer id) {
        cellarRepository.deleteById(id);
    }
}

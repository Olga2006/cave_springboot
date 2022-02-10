package com.orb.caveweb.controllers;

import com.orb.caveweb.dao.entity.PositionsGet;
import com.orb.caveweb.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/positions")
@RestController
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping(path = "/bottlePositions/{idBouteille}")
    public List<PositionsGet> getBottlePositions(@PathVariable Integer idBouteille) {
        List<PositionsGet> lp = positionService.getListeBottlePositions(idBouteille);
        return lp;
    }

    @DeleteMapping("/delPosition/{id}")
    void deletePosition(@PathVariable Integer id) {
        positionService.deleteById(id);
    }

}

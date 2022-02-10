package com.orb.caveweb.controllers;

import com.orb.caveweb.dao.entity.*;
import com.orb.caveweb.services.CellarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/cellars")
@RestController
public class CellarController {

    @Autowired
    private CellarService caveService;

    @GetMapping(path = "/userCellars/{idUser}")
    public List<CaveGet> getListeUserBottles(@PathVariable Integer idUser) {
        List<CaveGet> lc = caveService.getListeUserCaves(idUser);

        return lc;
    }

    @GetMapping(path = "/cellar/{idCellar}")
    public Optional<CaveFull> getCellar(@PathVariable Integer idCellar) {
        Optional<CaveFull> c = caveService.getCaveFull(idCellar);
        return c;
    }

    @PostMapping("/postCellar")
    public Cave saveBottle(@RequestBody Cave cave) {
        Cave c = caveService.saveCave(cave);
        return c;
    }

    @DeleteMapping("/delCellar/{idCave}")
    void deleteBottle(@PathVariable Integer idCave) {
        caveService.deleteById(idCave);
    }

}

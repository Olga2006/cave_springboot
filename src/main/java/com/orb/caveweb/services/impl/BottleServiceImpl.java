package com.orb.caveweb.services.impl;

import com.orb.caveweb.dao.BottleGetRepository;
import com.orb.caveweb.dao.BottleRepository;
import com.orb.caveweb.dao.ProducerRepository;
import com.orb.caveweb.dao.entity.Bouteille;
import com.orb.caveweb.dao.entity.BouteilleGet;
import com.orb.caveweb.dao.entity.Producteur;
import com.orb.caveweb.services.BottleService;
import com.orb.caveweb.tools.AWSUtils;
import com.orb.caveweb.tools.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BottleServiceImpl implements BottleService {

    public static final String PAGE = "BottleService";

    @Autowired
    public BottleGetRepository bottleGetRepository;

    @Autowired
    public BottleRepository bottleRepository;

    @Autowired
    public ProducerRepository producerRepository;

    @Override
    public List<BouteilleGet> getListeUserBottles(Integer idUser) {
        return bottleGetRepository.findByIdUtilisateurNative(idUser);
    }

    @Override
    public List<BouteilleGet> getListeCommonBottles(Integer idUser) {
        return bottleGetRepository.findByIdUserNotAndIsPayedForCommonWineproducerAllowedCLNative(Const.PAID_TO_COMMON_LIST, idUser);
    }

    @Override
    public BouteilleGet saveBottle(Bouteille bouteille, String imgToDel) {
        if (imgToDel != null) {
            Boolean isDeletedImg = new AWSUtils().deleteImage(imgToDel, bouteille.getIdUtilisateur(), PAGE);
        }
        Bouteille newBottle = bottleRepository.save(bouteille);
        return bottleGetRepository.findByIdNative(newBottle.getId());
    }

    @Override
    public void deleteById(Integer idBouteille, Integer idUser, String imgUrl) {
        if (imgUrl != null) {
            Boolean isDeletedImg = new AWSUtils().deleteImage(imgUrl, idUser, PAGE);
        }
        bottleRepository.deleteById(idBouteille);
    }

    @Override
    public BouteilleGet copyBottle(BouteilleGet bouteilleGetForCopy, Integer idUser) {
        Producteur producteurForCopy = null;
        Bouteille bouteilleForCopy = new Bouteille(
                null, bouteilleGetForCopy.getNom(), null, bouteilleGetForCopy.getCouleur(), bouteilleGetForCopy.getCru(),
                bouteilleGetForCopy.getAppelation(), bouteilleGetForCopy.getRegion(), bouteilleGetForCopy.getPays(),
                bouteilleGetForCopy.getTaille(), null, bouteilleGetForCopy.getPrixActuelle(),
                bouteilleGetForCopy.getDateDeProduction(), bouteilleGetForCopy.getDateGarder(), bouteilleGetForCopy.getImage(),
                idUser, null, 0,
                bouteilleGetForCopy.getEvaluation(), bouteilleGetForCopy.getUrlAchat(), true
        );
        List<Bouteille> theSameBottle;
        if (bouteilleGetForCopy.getIdProducteur() != null) {
            Optional<Producteur> producteurForCopyOpt = producerRepository.findById(bouteilleGetForCopy.getIdProducteur());
            producteurForCopy = producteurForCopyOpt.get();
            theSameBottle = bottleRepository.findByAllParamsBottleAndAllParamsProducerAndIdUser(bouteilleForCopy.getIdUtilisateur(),
                    bouteilleForCopy.getNom(), bouteilleForCopy.getPays(), bouteilleForCopy.getRegion(),
                    bouteilleForCopy.getAppelation(), bouteilleForCopy.getCouleur(), bouteilleForCopy.getCru(),
                    bouteilleForCopy.getDateDeProduction(), bouteilleForCopy.getTaille(),
                    producteurForCopy.getNom(), producteurForCopy.getAdresse(), producteurForCopy.getContact());
        } else {
            theSameBottle = bottleRepository.findByIdUtilisateurAndNomAndPaysAndRegionAndAppelationAndCouleurAndCruAndDateDeProductionAndTaille(
                    bouteilleForCopy.getIdUtilisateur(), bouteilleForCopy.getNom(), bouteilleForCopy.getPays(), bouteilleForCopy.getRegion(),
                    bouteilleForCopy.getAppelation(), bouteilleForCopy.getCouleur(), bouteilleForCopy.getCru(),
                    bouteilleForCopy.getDateDeProduction(), bouteilleForCopy.getTaille()
            );
        }
        if (!theSameBottle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Const.ERR_EXISTS);
        }
        if (producteurForCopy != null && producteurForCopy.getIsAllowedCL()) {
            List<Producteur> theSameProducteur = producerRepository.findByIdUtilisateurAndNomAndAdresseAndContact(idUser,
                    producteurForCopy.getNom(), producteurForCopy.getAdresse(), producteurForCopy.getContact());
            if (!theSameProducteur.isEmpty()) {
                bouteilleForCopy.setIdProducteur(theSameProducteur.get(0).getId());
            } else {
                Producteur newProducteurForCopy = new Producteur(null, producteurForCopy.getNom(),
                        producteurForCopy.getAdresse(), producteurForCopy.getContact(), idUser, true, producteurForCopy.getUrl());
                Producteur newProducteur = producerRepository.save(newProducteurForCopy);
                bouteilleForCopy.setIdProducteur(newProducteur.getId());
            }
        }
        if (bouteilleForCopy.getImage() != null) {
            String newImage = bouteilleForCopy.getImage().split("/")[0] + "/" + idUser.toString() + "_" + bouteilleForCopy.getImage().split("/")[1];
            Boolean isCopyed = new AWSUtils().CopyImage(bouteilleForCopy.getImage(), newImage, idUser, PAGE);
            if (isCopyed) {
                bouteilleForCopy.setImage(newImage);
            }
        }
        Bouteille newBouteille = bottleRepository.save(bouteilleForCopy);
        return bottleGetRepository.findByIdNative(newBouteille.getId());
    }
}

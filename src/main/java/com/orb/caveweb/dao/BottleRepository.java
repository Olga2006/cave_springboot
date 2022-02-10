package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.Bouteille;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BottleRepository extends CrudRepository<Bouteille, Integer> {

    @Query(value = "SELECT * FROM bouteille " +
            "LEFT OUTER JOIN producteur ON producteur.id = bouteille.id_producteur " +
            "WHERE bouteille.id_utilisateur = :idUtilisateur and bouteille.nom = :nom and bouteille.pays = :pays " +
            "and bouteille.region = :region and bouteille.appelation = :appelation and bouteille.couleur = :couleur " +
            "and bouteille.cru = :cru  and bouteille.date_de_production = :dateDeProduction and bouteille.taille = :taille " +
            "and producteur.nom = :nomProducteur and producteur.adresse = :adress and producteur.contact = :contact ", nativeQuery = true)
    List<Bouteille> findByAllParamsBottleAndAllParamsProducerAndIdUser(@Param("idUtilisateur") Integer idUtilisateur,
                                                                       @Param("nom") String nom,
                                                                       @Param("pays") String pays, @Param("region") String region,
                                                                       @Param("appelation") String appelation, @Param("couleur") String couleur,
                                                                       @Param("cru") String cru, @Param("dateDeProduction") Integer dateDeProduction,
                                                                       @Param("taille") Double taille, @Param("nomProducteur") String nomProducteur,
                                                                       @Param("adress") String adress, @Param("contact") String contact
    );

    List<Bouteille> findByIdUtilisateurAndNomAndPaysAndRegionAndAppelationAndCouleurAndCruAndDateDeProductionAndTaille(Integer idUtilisateur, String nom,
                                                                                                                       String pays, String region, String appelation,
                                                                                                                       String couleur, String cru, Integer dateDeProduction,
                                                                                                                       Double taille);


}

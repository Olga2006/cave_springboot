package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.Producteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProducerRepository extends CrudRepository<Producteur, Integer> {

    List<Producteur> findByIdUtilisateur(Integer idUtilisateur);

    @Query(value = "SELECT * FROM producteur LEFT OUTER JOIN utilisateur ON utilisateur.id = producteur.id_utilisateur " +
            "WHERE producteur.is_allowed_cl = 1 and utilisateur.is_wineproducer = 1 and producteur.id_utilisateur != :idUtilisateur  and  " +
            " utilisateur.is_payed >= :isPayed ORDER BY producteur.nom", nativeQuery = true)
    List<Producteur> findByIdUtilisateurNotAndIsPayedNative(
            @Param("isPayed") Integer isPayed,
            @Param("idUtilisateur") Integer idUtilisateur
    );

    List<Producteur> findByIdUtilisateurAndNomAndAdresseAndContact(Integer idUtilisateur, String nom, String adresse, String contact);

}

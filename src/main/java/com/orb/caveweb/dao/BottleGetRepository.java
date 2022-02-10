package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.BouteilleGet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BottleGetRepository extends CrudRepository<BouteilleGet, Integer> {

    @Query(value = "SELECT bouteille.* , producteur.nom as nom_producteur, Count(positions.id) as nbr_positions FROM bouteille " +
            "LEFT OUTER JOIN positions ON positions.id_bouteille = bouteille.id " +
            "LEFT OUTER JOIN producteur ON producteur.id = bouteille.id_producteur " +
            "WHERE bouteille.id_utilisateur = :idUtilisateur " +
            "GROUP BY bouteille.id ORDER BY bouteille.nom", nativeQuery = true)
    List<BouteilleGet> findByIdUtilisateurNative(@Param("idUtilisateur") Integer idUtilisateu);

    @Query(value = "SELECT bouteille.* , producteur.nom as nom_producteur, Count(positions.id) as nbr_positions FROM bouteille " +
            "LEFT OUTER JOIN positions ON positions.id_bouteille = bouteille.id " +
            "LEFT OUTER JOIN producteur ON producteur.id = bouteille.id_producteur " +
            "WHERE bouteille.id = :idBottle " +
            "GROUP BY bouteille.id ORDER BY bouteille.nom", nativeQuery = true)
    BouteilleGet findByIdNative(@Param("idBottle") Integer idBottle);

    @Query(value = "SELECT bouteille.*, producteur.nom as nom_producteur, Count(bouteille.id) as nbr_positions FROM bouteille " +
            "LEFT OUTER JOIN utilisateur ON utilisateur.id = bouteille.id_utilisateur " +
            "LEFT OUTER JOIN producteur ON producteur.id = bouteille.id_producteur " +
            "WHERE bouteille.is_allowed_cl = 1 and utilisateur.is_wineproducer = 1 " +
            "and bouteille.id_utilisateur != :idUtilisateur  and  " +
            "utilisateur.is_payed >= :isPayed GROUP BY bouteille.id ORDER BY bouteille.nom", nativeQuery = true)
    List<BouteilleGet> findByIdUserNotAndIsPayedForCommonWineproducerAllowedCLNative(
            @Param("isPayed") Integer isPayed,
            @Param("idUtilisateur") Integer idUtilisateur
    );
}

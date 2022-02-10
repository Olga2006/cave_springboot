package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.PositionsGet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionsGetRepository extends CrudRepository<PositionsGet, Integer> {

    @Query(value = "SELECT positions.*, CONCAT_WS('_', cave.nom, compartiment.reference_c, rangee.reference_r, positions.reference_p) " +
            "as full_ref_pos FROM positions " +
            "INNER JOIN rangee ON rangee.id = positions.id_rangee " +
            "INNER JOIN compartiment ON compartiment.id = rangee.id_compartiment " +
            "INNER JOIN cave ON cave.id = compartiment.id_cave " +
            "WHERE positions.id_bouteille = :idBouteille ORDER BY cave.nom", nativeQuery = true)
    List<PositionsGet> findByIdBouteilleNative(
            @Param("idBouteille") Integer idBouteille
    );

}

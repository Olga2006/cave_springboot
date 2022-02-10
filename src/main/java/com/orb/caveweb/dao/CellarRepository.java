package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.Cave;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CellarRepository extends CrudRepository<Cave, Integer> {

    @Query(value = "SELECT id FROM cave WHERE id_utilisateur = :idUser", nativeQuery = true)
    List<Integer> getListIdsNative(
            @Param("idUser") Integer idUser
    );
}

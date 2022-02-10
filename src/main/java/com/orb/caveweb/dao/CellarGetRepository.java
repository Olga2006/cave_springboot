package com.orb.caveweb.dao;

import com.orb.caveweb.dao.entity.CaveGet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CellarGetRepository extends CrudRepository<CaveGet, Integer> {

    @Query(value = "CALL afficher_all_data_cave(:idCave)", nativeQuery = true)
    CaveGet findByIdCaveNative(@Param("idCave") Integer idCave);
}

package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.General;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface GeneralRepository extends JpaRepository<General, Integer> {

    @Query(value = "SELECT * FROM tbl_general ORDER BY id DESC LIMIT 1", nativeQuery = true)
    General ultimoId();

    @Query(value = "SELECT count(id) AS 'cantidad de bovinos' FROM tbl_general",nativeQuery = true)
    Integer cantidadBovinos();

//    @Query(value = "SELECT MAX(id) AS ulti_d FROM tbl_general", nativeQuery = true)
//    General ulti_id();

}

package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EngordeRepository extends JpaRepository<Engorde, Integer> {
    @Query(value = "SELECT * FROM tbl_engorde WHERE id LIKE :id", nativeQuery = true)
    Engorde buscarPorIdEngorde(@Param("id") Integer id);
}

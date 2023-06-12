package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Secado;
import com.example.vaqui.Entidad.Ternero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TerneroRepository extends JpaRepository<Ternero, Integer> {
    @Query(value = "SELECT * FROM tbl_ternero WHERE id LIKE :id", nativeQuery = true)
    Ternero buscarPorIdTernero(@Param("id") Integer id);
}

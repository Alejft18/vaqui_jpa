package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Entidad.Secado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecadoRepository extends JpaRepository<Secado, Integer> {
    @Query(value = "SELECT * FROM tbl_secado WHERE id LIKE :id", nativeQuery = true)
    Secado buscarPorIdSecado(@Param("id") Integer id);
}

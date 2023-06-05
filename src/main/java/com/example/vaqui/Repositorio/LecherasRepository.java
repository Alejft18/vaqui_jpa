package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Lechera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecherasRepository extends JpaRepository<Lechera, Integer> {

    @Query(value = "select id, peso_kilos, litro_producidos, fecha_revision, fecha_parto, fecha_ordeno,cant_partos, categoria from tbl_lechera", nativeQuery = true)
    List<Lechera>listarLecherasId();
}

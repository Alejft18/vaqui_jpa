package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Lechera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecherasRepository extends JpaRepository<Lechera, Integer> {
}

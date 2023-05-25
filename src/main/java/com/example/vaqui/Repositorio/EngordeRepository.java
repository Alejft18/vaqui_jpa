package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EngordeRepository extends JpaRepository<Engorde, Integer> {
}

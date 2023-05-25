package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Entidad.Gestacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface GeneralRepository extends JpaRepository<General, Integer> {
}

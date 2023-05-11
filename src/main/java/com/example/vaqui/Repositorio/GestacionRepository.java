package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Gestacion;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface GestacionRepository extends CrudRepository<Gestacion, BigInteger> {
}

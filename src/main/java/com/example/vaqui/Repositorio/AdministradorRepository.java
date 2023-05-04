package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Administrador;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface AdministradorRepository extends CrudRepository<Administrador, BigInteger> {
}

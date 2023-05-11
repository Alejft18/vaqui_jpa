package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface EmpleadoRepository extends CrudRepository<Empleado, BigInteger> {
}

package com.example.vaqui.Repositorio;

import com.example.vaqui.Entidad.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
}

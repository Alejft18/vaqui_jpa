package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Usuario;
import com.example.vaqui.Repositorio.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class ServicioUsuario {
    UsuarioRepository repository;

    public ServicioUsuario(UsuarioRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Usuario> listar(){
        return (ArrayList<Usuario>) repository.findAll();
    }

    public String agregarUsuario(Usuario usuario){
        repository.save(usuario);
        return "Ingreso esitoso del usuario";
    }

    public String actualizarUsuario(Usuario usuario){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(usuario.getId())){
            repository.save(usuario);
            mensaje ="Se actualizo correctamente la informacion";
        }
        return mensaje;
    }

    public String eliminarUsuario(BigInteger id){
        String mensaje = "Error al eliminar el usuario";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje= "Eliminacion exotosa del usuario";
        }
        return mensaje;
    }

}

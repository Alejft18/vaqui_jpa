package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Administrador;
import com.example.vaqui.Repositorio.AdministradorRepository;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class ServicioAdministrador {
    AdministradorRepository repository;

    public ServicioAdministrador(AdministradorRepository repository){
        this.repository = repository;
    }

    public ArrayList<Administrador> listar(){
        return (ArrayList<Administrador>) repository.findAll();
    }

    public String agregarAdmin(Administrador admin){
        repository.save(admin);
        return "Ingreso exitoso del administrador";
    }

    public String eliminarAdmin(BigInteger id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente al administrador";
        }
        return mensaje;
    }

    public String actualizarAdmin(Administrador admin){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(admin.getId())){
            repository.save(admin);
            mensaje ="Se actualizo correctamente la información";
        }
        return mensaje;
    }
}

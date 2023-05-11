package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Administrador;
import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Repositorio.EngordeRepository;

import java.math.BigInteger;
import java.util.ArrayList;

public class ServicioEngorde {
    EngordeRepository repository;

    public ServicioEngorde(EngordeRepository repository){this.repository = repository;}

    public ArrayList<Engorde> listar(){
        return (ArrayList<Engorde>) repository.findAll();
    }

    public String agregarEngorde(Engorde engorde){
        repository.save(engorde);
        return "Ingreso exitoso en engorde";
    }

    public String eliminarEngorde(BigInteger id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente al administrador";
        }
        return mensaje;
    }

    public String actualizarEngorde(Engorde engorde){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(engorde.getTbl_general())){
            repository.save(engorde);
            mensaje ="Se actualizo correctamente la información";
        }
        return mensaje;
    }
}

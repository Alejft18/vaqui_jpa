package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.TerneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioTernero {
    TerneroRepository repository;
    GeneralRepository genrepository;


    public ServicioTernero(TerneroRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Ternero> listar(){
        return (ArrayList<Ternero>) repository.findAll();
    }

    public String agregarTernero(Ternero ternero){
        repository.save(ternero);
        return "Ingreso exitoso";
    }

    public String eliminarTernero (int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente";
        }
        return mensaje;
    }

    /*public String actualizarTernero(Ternero ternero){
        String mensaje = "Error al actualizar";
        if (repository.existsById(ternero.getId())){
            repository.save(ternero);
            mensaje ="Se actualizo correctamente";
        }
        return mensaje;
    }*/
}

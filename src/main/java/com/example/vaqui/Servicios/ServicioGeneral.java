package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Repositorio.GeneralRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioGeneral {
    GeneralRepository repository;

    public ServicioGeneral(GeneralRepository repository) {
        this.repository = repository;
    }

    public ArrayList<General> listar(){
        return (ArrayList<General>) repository.findAll();
    }

    public General ultimoId(){
        return repository.ultimoId();
    }

//    public General ulti_id(){
//        return repository.ulti_id();
//    }

    public  String agregarGeneral(General general){
        repository.save(general);
        return "Ingreso exitoso";
    }

    public String actualizarBovinoGeneral(General general){
        String mensaje="Error al actualizar el bovino";
        if (repository.existsById(general.getId())){
            repository.save(general);
            mensaje = "Actualizacion exitosa del bovino";
        }
        return mensaje;
    }


    public String eliminarBovinoGeneral(int id){
        String mensaje="Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }

    public Integer cantidadBovinos(){return repository.cantidadBovinos();}
}

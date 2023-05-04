package com.example.vaqui.Servicio;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Repositorio.GeneralRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioGeneral {
    GeneralRepository repository;

    public ServicioGeneral(GeneralRepository repository){this.repository = repository;}
    public ArrayList<General> listar(){
        return (ArrayList<General>) repository.findAll();
    }

    public String agregarGeneral(General general){
        repository.save(general);
        return "Ingreso exitoso";
    }

    public String eliminarGeneral(int id){
        String mensaje="Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }
}

package com.example.vaqui.Servicio;

import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Repositorio.GestacionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ServicioGestacion {
    GestacionRepository repository;

    public ServicioGestacion(GestacionRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Gestacion> listar(){
        return (ArrayList<Gestacion>) repository.findAll();
    }

    public  String agregarGestacion(Gestacion gestacion){
        repository.save(gestacion);
        return "Ingreso exitoso";
    }

    public String eliminarGestacion(int id){
        String mensaje="Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }
}

package com.example.vaqui.Servicio;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Repositorio.EngordeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioEngorde {
    EngordeRepository repository;

    public ServicioEngorde(EngordeRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Engorde> listar(){
        return (ArrayList<Engorde>) repository.findAll();
    }

    public  String agregarEngorde(Engorde engorde){
        repository.save(engorde);
        return "Ingreso exitoso";
    }

    public String eliminarEngorde(int id){
        String mensaje="Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }
}

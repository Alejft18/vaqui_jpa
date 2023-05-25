package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Entidad.Toro;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.TerneroRepository;
import com.example.vaqui.Repositorio.ToroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioToro {
    ToroRepository repository;
    GeneralRepository genrepository;


    public ServicioToro(ToroRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Toro> listar(){
        return (ArrayList<Toro>) repository.findAll();
    }

    public String agregarToro(Toro toro){
        repository.save(toro);
        return "Ingreso exitoso";
    }

    public String eliminarToro(int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente";
        }
        return mensaje;
    }

    /*public String actualizarToro(Toro toro){
        String mensaje = "Error al actualizar";
        if (repository.existsById(toro.getId())){
            repository.save(toro);
            mensaje ="Se actualizo correctamente";
        }
        return mensaje;
    }*/
}

package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.LecherasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

@Service
public class ServiciosLecheras {

    LecherasRepository repository;
    GeneralRepository genrepository;


    public ServiciosLecheras(LecherasRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Lechera> listarLecheras(){
        return (ArrayList<Lechera>) repository.findAll();
    }

    public List<Lechera> listarLecherasId() {
        return repository.listarLecherasId();
    }

    public String agregarLecheras(Lechera lechera){
        repository.save(lechera);
        return "Se ingreso esta vaquita lechera con exito";
    }


    public String eliminarLecheras(int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }


//    public String actualizarLecheras(Lechera lechera){
//        String mensaje = "Error al actualizar";
//        if (repository.existsById(lechera.getId())){
//            repository.save(lechera);
//            mensaje = "Se actualizo exitosamente";
//        }
//        return mensaje;
//    }


}

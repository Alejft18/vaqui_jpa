package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Repositorio.EngordeRepository;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.GestacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioGestacion {
    GestacionRepository repository;
    GeneralRepository genrepository;

    public ServicioGestacion(GestacionRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Gestacion> listarGestacion(){
        return (ArrayList<Gestacion>) repository.findAll();
    }

    public String agregarGestacion(Gestacion gestacion, int id_Gestacion){

        General Gen = genrepository.findById(id_Gestacion).get();

        if (genrepository.findById(id_Gestacion).isPresent()){
            gestacion.setId_gestacion(Gen);
            repository.save(gestacion);
            return "Se ingreso esta vaquita con exito";
        }
        return "El bovino no existe";
    }


}

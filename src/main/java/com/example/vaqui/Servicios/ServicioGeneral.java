package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Repositorio.GeneralRepository;

import java.util.ArrayList;

public class ServicioGeneral {
    GeneralRepository repository;

    public ServicioGeneral(GeneralRepository repository) {
        this.repository = repository;
    }

    public ArrayList<General> listar(){
        return (ArrayList<General>) repository.findAll();
    }

    /*public  String agregarGeneral(General general){
        repository.save(general);
        return "Ingreso exitoso";
    }*/
}

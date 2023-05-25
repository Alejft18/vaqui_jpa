package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import com.example.vaqui.Repositorio.EngordeRepository;
import com.example.vaqui.Repositorio.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioEngorde {
    EngordeRepository repository;
    GeneralRepository genrepository;


    public ServicioEngorde(EngordeRepository repository, GeneralRepository genrepository) {
        this.repository = repository;
        this.genrepository = genrepository;
    }


    public ArrayList<Engorde> listarEngorde(){
        return (ArrayList<Engorde>) repository.findAll();
    }

    /*public String agregarEngorde(Engorde engorde, int id_Engorde){

        General Gen = genrepository.findById(id_Engorde).get();

        if (genrepository.findById(id_Engorde).isPresent()){
            engorde.setId_engorde(Gen);
            repository.save(engorde);
            return "Se ingreso esta vaquita con exito";
        }
        return "El bovino no existe";
    }

    public String eliminarEngorde(Integer id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente al administrador";
        }
        return mensaje;
    }*/

    /*public String actualizarEngorde(Engorde engorde){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(engorde.getTbl_general())){
            repository.save(engorde);
            mensaje ="Se actualizo correctamente la información";
        }
        return mensaje;
    }*/
}

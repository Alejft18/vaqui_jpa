package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Entidad.Secado;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.LecherasRepository;
import com.example.vaqui.Repositorio.SecadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiciosSecado {
    SecadoRepository repository;
    GeneralRepository genrepository;


    public ServiciosSecado(SecadoRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Secado> listarSecado(){
        return (ArrayList<Secado>) repository.findAll();
    }

    public String agregarSecado(Secado secado){
        repository.save(secado);
        return "Se ingreso esta vaquita con exito";
    }


    public String eliminarSecado(int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }


   public String actualizarSecado(Secado secado){
       String mensaje = "Error al actualizaar";
       if (repository.existsById(secado.getId_secado().getId())){
           repository.save(secado);
           mensaje = "Se actualizo exitosamente";
       }
       return mensaje;
   }

}

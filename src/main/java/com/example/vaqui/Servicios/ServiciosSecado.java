package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Entidad.Secado;
import com.example.vaqui.Repositorio.LecherasRepository;
import com.example.vaqui.Repositorio.SecadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiciosSecado {

    SecadoRepository repository;

    public ServiciosSecado(SecadoRepository repository){this.repository = repository;}

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
        String mensaje = "Error al actualizar";
        if (repository.existsById(secado.getId())){
            repository.save(secado);
            mensaje = "Se actualizo exitosamente";
        }
        return mensaje;
    }

}

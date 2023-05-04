package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Empleado;
import com.example.vaqui.Repositorio.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class ServicioEmpleado {
    EmpleadoRepository repository;

    public ServicioEmpleado(EmpleadoRepository repository){
        this.repository = repository;
    }

    public ArrayList<Empleado> listar(){
        return (ArrayList<Empleado>) repository.findAll();
    }


    public String agregarEmpleado(Empleado emple){
        repository.save(emple);
        return "Ingreso exitoso del empleado";
    }

    public String eliminarEmpleado(BigInteger id){
        String mensaje = "Error al eliminar empleado";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente el empleado";
        }
        return mensaje;
    }

    public String actualizarEmpleado(Empleado emple){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(emple.getId())){
            repository.save(emple);
            mensaje ="Se actualizo correctamente la informacion";
        }
        return mensaje;
    }

}

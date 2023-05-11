package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Empleado;
import com.example.vaqui.Servicios.ServicioEmpleado;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class ControladorEmpleado {
    ServicioEmpleado servicio;

    public ControladorEmpleado(ServicioEmpleado servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarEmpleado")
    public ArrayList<Empleado> listarEmpleado(){
        return servicio.listar();
    }

    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(@RequestBody Empleado empleado){
        return servicio.agregarEmpleado(empleado);
    }

    @DeleteMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable("id") BigInteger id){
        return servicio.eliminarEmpleado(id);
    }

    @PutMapping("/actualizarEmpleado")
    public String actualizarEmpleado(@RequestBody Empleado empleado){
        return servicio.actualizarEmpleado(empleado);
    }
}

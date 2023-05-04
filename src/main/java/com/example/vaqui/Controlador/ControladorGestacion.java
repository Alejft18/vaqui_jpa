package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Servicio.ServicioGeneral;
import com.example.vaqui.Servicio.ServicioGestacion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControladorGestacion {

    ServicioGestacion servicio;

    public ControladorGestacion(ServicioGestacion servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarGestacion")
    public ArrayList<Gestacion> listarGestacion(){
        return servicio.listar();
    }

    @PostMapping("/agregarGestacion")
    public String agregarGestacion(@RequestBody Gestacion gestacion){
        return servicio.agregarGestacion(gestacion);
    }

    @DeleteMapping("/eliminarGestacion/{id}")
    public String eliminarGestacion(@PathVariable("id") int id){
        return servicio.eliminarGestacion(id);
    }
}

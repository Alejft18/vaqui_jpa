package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Servicio.ServicioGeneral;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControladorGeneral {
    ServicioGeneral servicio;

    public ControladorGeneral(ServicioGeneral servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarGeneral")
    public ArrayList<General> listarGeneral(){
        return servicio.listar();
    }

    @PostMapping("/agregarGeneral")
    public String agregarGeneral(@RequestBody General general){
        return servicio.agregarGeneral(general);
    }

    @DeleteMapping("/eliminarGeneral/{id}")
    public String eliminarGeneral(@PathVariable("id") int id){
        return servicio.eliminarGeneral(id);
    }
}

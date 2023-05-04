package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Servicios.ServicioTernero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class ControladorTernero {

    ServicioTernero servicio;

    public ControladorTernero(ServicioTernero servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarTernero")
    public ArrayList<Ternero> listarTernero(){
        return servicio.listar();
    }

    @PostMapping("/agregarTernero")
    public String agregarTernero(@RequestBody Ternero ternero){
        return servicio.agregarTernero(ternero);
    }

    @DeleteMapping("/eliminarTernero/{id}")
    public String eliminarTernero(@PathVariable("id") int id){
        return servicio.eliminarTernero(id);
    }

    @PutMapping("/actualizarTernero")
    public String actualizarTernero(@RequestBody Ternero ternero){
        return servicio.actualizarTernero(ternero);
    }
}

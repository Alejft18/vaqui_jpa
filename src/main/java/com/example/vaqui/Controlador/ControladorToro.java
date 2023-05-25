package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Entidad.Toro;
import com.example.vaqui.Servicios.ServicioTernero;
import com.example.vaqui.Servicios.ServicioToro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorToro {
    ServicioToro servicio;

    public ControladorToro(ServicioToro servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarToro")
    public ArrayList<Toro> listarToro(){
        return servicio.listar();
    }

    @PostMapping("/agregarToro")
    public String agregarToro(@RequestBody Toro toro){
        return servicio.agregarToro(toro);
    }

    @DeleteMapping("/eliminarToro/{id}")
    public String eliminarToro(@PathVariable("id") int id){
        return servicio.eliminarToro(id);
    }

    /*@PutMapping("/actualizarToro")
    public String actualizarToro(@RequestBody Toro toro){
        return servicio.actualizarToro(toro);
    }*/
}

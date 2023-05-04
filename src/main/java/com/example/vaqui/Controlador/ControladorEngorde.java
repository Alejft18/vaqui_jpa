package com.example.vaqui.Controlador;
import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Servicio.ServicioEngorde;
import com.example.vaqui.Servicio.ServicioGestacion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControladorEngorde {

    ServicioEngorde servicio;

    public ControladorEngorde(ServicioEngorde servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarEngorde")
    public ArrayList<Engorde> listarEngorde(){
        return servicio.listar();
    }

    @PostMapping("/agregarEngorde")
    public String agregarEngorde(@RequestBody Engorde engorde){
        return servicio.agregarEngorde(engorde);
    }

    @DeleteMapping("/eliminarEngorde/{id}")
    public String eliminarEngorde(@PathVariable("id") int id){
        return servicio.eliminarEngorde(id);
    }
}

package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Servicios.ServiciosLecheras;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class ControladorLecheras {

    ServiciosLecheras servicios;

    public ControladorLecheras(ServiciosLecheras servicios){this.servicios = servicios;}

    @GetMapping("/listarLecheras")
    public ArrayList<Lechera> listarLechera(){return servicios.listarLecheras();}

    @PostMapping("/agregarLecheras")
    public String agregarLecheras(@RequestBody Lechera lechera){return servicios.agregarLecheras(lechera);}

    @DeleteMapping("/eliminarLecheras/{id}")
    public String eliminarLecheras(@PathVariable("id")int id){return servicios.eliminarLecheras(id);}

    @PutMapping("/actualizarLecheras")
    public String actualizarLecheras(@RequestBody Lechera lechera){return servicios.actualizarLecheras(lechera);}

}

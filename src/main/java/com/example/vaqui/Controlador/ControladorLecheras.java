package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Servicios.ServiciosLecheras;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorLecheras {

    ServiciosLecheras servicios;

    public ControladorLecheras(ServiciosLecheras servicios){this.servicios = servicios;}

    @GetMapping("/listarLecheras")
    public ArrayList<Lechera> listarLechera(){return servicios.listarLecheras();}


    @GetMapping("/listarLecherasId")
    public ResponseEntity<List<Lechera>> listarLecherasId() {
        List<Lechera> lecheras = servicios.listarLecherasId();
        return ResponseEntity.ok(lecheras);
    }

    @PostMapping("/agregarLecheras")
    public String agregarLecheras(@RequestBody Lechera lechera){return servicios.agregarLecheras(lechera);}

    @DeleteMapping("/eliminarLecheras/{id}")
    public String eliminarLecheras(@PathVariable("id")int id){return servicios.eliminarLecheras(id);}

//    @PutMapping("/actualizarLecheras")
//    public String actualizarLecheras(@RequestBody Lechera lechera){return servicios.actualizarLecheras(lechera);}

}

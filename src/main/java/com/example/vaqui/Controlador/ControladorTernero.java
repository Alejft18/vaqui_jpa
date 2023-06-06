package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Servicios.ServicioTernero;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorTernero {

    ServicioTernero servicio;

    public ControladorTernero(ServicioTernero servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarTerneroCodigo")
    public ArrayList<Ternero> listarTerneroCodigo(){
        return servicio.listarTerneroCodigo();
    }

    @GetMapping("/listarTerneros")
    public ResponseEntity<String> listarTernero(){
        JSONArray jsonArray = servicio.listarTernero();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);

    }

    @PostMapping("/agregarTernero")
    public String agregarTernero(@RequestBody Ternero ternero){
        return servicio.agregarTernero(ternero);
    }

    @DeleteMapping("/eliminarTernero/{id}")
    public String eliminarTernero(@PathVariable("id") int id){
        return servicio.eliminarTernero(id);
    }

    /*@PutMapping("/actualizarTernero")
    public String actualizarTernero(@RequestBody Ternero ternero){
        return servicio.actualizarTernero(ternero);
    }*/
}

package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Entidad.Toro;
import com.example.vaqui.Servicios.ServicioTernero;
import com.example.vaqui.Servicios.ServicioToro;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorToro {
    ServicioToro servicio;

    public ControladorToro(ServicioToro servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarToroCodigo")
    public ArrayList<Toro> listarTorosCodigo(){
        return servicio.listarTorosCodigo();
    }

    @GetMapping("/listarToros")
    public ResponseEntity<String> listarToros(){
        JSONArray jsonArray = servicio.listarToros();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
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

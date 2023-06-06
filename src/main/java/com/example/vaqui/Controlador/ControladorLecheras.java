package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Servicios.ServiciosLecheras;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorLecheras {

    ServiciosLecheras servicios;

    public ControladorLecheras(ServiciosLecheras servicios){this.servicios = servicios;}


    @GetMapping("/listarLecheras")
    public ResponseEntity<String> listarLecheras(){
        JSONArray jsonArray=servicios.listarLecharas();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }

    @PostMapping("/agregarLecheras")
    public String agregarLecheras(@RequestBody Lechera lechera){return servicios.agregarLecheras(lechera);}

    @DeleteMapping("/eliminarLecheras/{id}")
    public String eliminarLecheras(@PathVariable("id")int id){return servicios.eliminarLecheras(id);}

//    @PutMapping("/actualizarLecheras")
//    public String actualizarLecheras(@RequestBody Lechera lechera){return servicios.actualizarLecheras(lechera);}

}

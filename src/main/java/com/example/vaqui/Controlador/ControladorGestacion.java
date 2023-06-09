package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Servicios.ServicioEngorde;
import com.example.vaqui.Servicios.ServicioGestacion;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorGestacion {

    private ServicioGestacion servicio;

    public ControladorGestacion(ServicioGestacion servicio){this.servicio =  servicio;}

    @GetMapping("/listarGestacion")
    public ResponseEntity<String> listarEngorde(){
        JSONArray jsonArray= servicio.listarGestacion();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }


    @PostMapping("/agregarGestacion/{id}")
    public String agregarGestacion(@RequestBody Gestacion gestacion, @PathVariable("id") Integer id){
        return servicio.agregarGestacion(gestacion,id);
    }
}

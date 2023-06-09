package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import com.example.vaqui.Servicios.ServicioEngorde;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorEngorde {
    private ServicioEngorde servicio;

    public ControladorEngorde(ServicioEngorde servicio){this.servicio =  servicio;}

    @GetMapping("/listarEngorde")
    public ResponseEntity<String> listarEngorde(){
        JSONArray jsonArray=servicio.listarEngorde();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }

    @PostMapping("/ingresarEngorde/{id}")
    public String ingresarEngorde(@RequestBody Engorde engorde,@PathVariable("id") Integer id){
        return servicio.agregarEngorde(engorde,id);
    }

    @GetMapping("/buscarEngordeId/{id}")
    public Engorde buscarEngordeId(@PathVariable("id")Integer id){
        return servicio.buscarEngordeId(id);
    }

    @PutMapping("/actualizarEngorde/{id}")
    public String actualizarEngorde(@RequestBody Engorde engorde, @PathVariable("id") Integer id){
        return servicio.actualizarEngorde(engorde,id);
    }

    @DeleteMapping("/eliminarEngorde/{id}")
    public String eliminarEngorde(@PathVariable("id") Integer id){
        return servicio.eliminarEngorde(id);
    }
}

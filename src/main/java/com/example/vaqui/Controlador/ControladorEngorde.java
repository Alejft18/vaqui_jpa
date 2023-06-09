package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Servicios.ServicioEngorde;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*@PostMapping("/agregarEngorde/{id}")
    public String agregarEngorde(@RequestBody Engorde engorde, @PathVariable("id") int id){
        return servicio.agregarEngorde(engorde,id);
    }*/
}

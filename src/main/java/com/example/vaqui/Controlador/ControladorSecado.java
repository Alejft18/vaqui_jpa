package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Entidad.Secado;
import com.example.vaqui.Servicios.ServiciosLecheras;
import com.example.vaqui.Servicios.ServiciosSecado;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorSecado {

    ServiciosSecado servicios;

    public ControladorSecado(ServiciosSecado servicios){this.servicios = servicios;}

    @GetMapping("/listarSecadoCodigo")
    public ArrayList<Secado>listarSecadoCodigo(){
        return servicios.listarSecadoCodigo();
    }

    @GetMapping("/listarSecado")
    public ResponseEntity<String> listarSecado(){
        JSONArray jsonArray = servicios.listarSecado();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }

    @PostMapping("/agregarSecado")
    public String agregarSecado(@RequestBody Secado secado){return servicios.agregarSecado(secado);}

    @DeleteMapping("/eliminarSecado/{id}")
    public String eliminarSecado(@PathVariable("id")int id){return servicios.eliminarSecado(id);}

    @PutMapping("/actualizarSecado")
    public String actualizarSecado(@RequestBody Secado secado){return servicios.actualizarSecado(secado);}

}

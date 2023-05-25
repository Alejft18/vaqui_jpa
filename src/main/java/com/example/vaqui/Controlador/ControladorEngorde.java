package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Servicios.ServicioEngorde;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorEngorde {
    private ServicioEngorde servicio;

    public ControladorEngorde(ServicioEngorde servicio){this.servicio =  servicio;}

    @GetMapping("/listarEngorde")
    public List<Engorde> listarEngorde(){return servicio.listarEngorde();}

    /*@PostMapping("/agregarEngorde/{id}")
    public String agregarEngorde(@RequestBody Engorde engorde, @PathVariable("id") int id){
        return servicio.agregarEngorde(engorde,id);
    }*/
}

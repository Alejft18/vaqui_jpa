package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Servicios.ServicioEngorde;
import com.example.vaqui.Servicios.ServicioGestacion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorGestacion {

    private ServicioGestacion servicio;

    public ControladorGestacion(ServicioGestacion servicio){this.servicio =  servicio;}

    @GetMapping("/listarGestacion")
    public List<Gestacion> listarGestacion(){return servicio.listarGestacion();}

    @PostMapping("/agregarGestacion/{id}")
    public String agregarGestacion(@RequestBody Gestacion gestacion, @PathVariable("id") int id){
        return servicio.agregarGestacion(gestacion,id);
    }
}

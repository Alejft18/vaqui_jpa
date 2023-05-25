package com.example.vaqui.Controlador;

import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Entidad.Secado;
import com.example.vaqui.Servicios.ServiciosLecheras;
import com.example.vaqui.Servicios.ServiciosSecado;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorSecado {

    ServiciosSecado servicios;

    public ControladorSecado(ServiciosSecado servicios){this.servicios = servicios;}

    @GetMapping("/listarSecado")
    public ArrayList<Secado> listarSecado(){return servicios.listarSecado();}

    @PostMapping("/agregarSecado")
    public String agregarSecado(@RequestBody Secado secado){return servicios.agregarSecado(secado);}

    @DeleteMapping("/eliminarSecado/{id}")
    public String eliminarSecado(@PathVariable("id")int id){return servicios.eliminarSecado(id);}

//    @PutMapping("/actualizarSecado")
//    public String actualizarSecado(@RequestBody Secado secado){return servicios.actualizarSecado(secado);}

}

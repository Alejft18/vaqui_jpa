package com.example.vaqui.Controlador;


import com.example.vaqui.Entidad.Administrador;
import com.example.vaqui.Servicios.ServicioAdministrador;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class ControladorAdmin {
    ServicioAdministrador servicio;

    public ControladorAdmin(ServicioAdministrador servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarAdminisrador")
    public ArrayList<Administrador> listarAdmin(){
        return servicio.listar();
    }

    @PostMapping("/agregarAdmin")
    public String agregarAdmin(@RequestBody Administrador administrador){
        return servicio.agregarAdmin(administrador);
    }

    @DeleteMapping("/eliminarAdmin/{id}")
    public String eliminarAdmin(@PathVariable("id") BigInteger id){

        return servicio.eliminarAdmin(id);
    }

    @PutMapping("/actualizarAdmin")
    public String actualizarAdmin(@RequestBody Administrador administrador){
        return servicio.actualizarAdmin(administrador);
    }

}

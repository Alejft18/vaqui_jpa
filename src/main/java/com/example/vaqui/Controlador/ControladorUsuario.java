package com.example.vaqui.Controlador;


import com.example.vaqui.Entidad.Usuario;
import com.example.vaqui.Servicios.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorUsuario {
    ServicioUsuario servicio;


    public ControladorUsuario(ServicioUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarUsuario")
    public ArrayList<Usuario> listarUsario(){
        return servicio.listar();
    }

    @PostMapping("/agregarUsuario")
    public String agregarUsuario(@RequestBody Usuario usuario){
        return servicio.agregarUsuario(usuario);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable("id") BigInteger id){
        return servicio.eliminarUsuario(id);
    }

    @PutMapping("/actualizarUsuario")
    public String actualizarUsuario(@RequestBody Usuario usuario){
        return servicio.actualizarUsuario(usuario);
    }
}

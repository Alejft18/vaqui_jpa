package com.example.vaqui.Controlador;


import com.example.vaqui.Entidad.Usuario;
import com.example.vaqui.Servicios.ServicioUsuaio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class ControladorUsuario {
    ServicioUsuaio servicio;


    public ControladorUsuario(ServicioUsuaio servicio) {
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
    public String eliminarUsuario(@PathVariable("id") Long id){
        return servicio.eliminarUsuario(id);
    }

    @PutMapping("/actualizarUsuario")
    public String actualizarUsuario(@RequestBody Usuario usuario){

        return servicio.actualizarUsuario(usuario);
    }
}

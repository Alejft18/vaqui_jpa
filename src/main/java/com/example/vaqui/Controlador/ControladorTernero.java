package com.example.vaqui.Controlador;

import com.example.vaqui.Servicios.ServicioTernero;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class ControladorTernero {

    ServicioTernero servicio;

    public ControladorTernero(ServicioTernero servicio){
        this.servicio = servicio;
    }
}

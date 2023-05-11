package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_administrador")
    @JsonIgnore
    private Administrador id_administrador;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empleaado")
    @JsonIgnore
    private Empleado id_empleado;


    public Usuario(Long id, String correo, String contrasena, Administrador id_administrador, Empleado id_empleado) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.id_administrador = id_administrador;
        this.id_empleado = id_empleado;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Administrador getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Administrador id_administrador) {
        this.id_administrador = id_administrador;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }
}

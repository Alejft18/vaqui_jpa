package com.example.vaqui.Entidad;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "tbl_empleado")
public class Empleado {
    @Id
    @Column(nullable = false, length = 10,unique = true)
    private BigInteger id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String Apellido;

    @Column(nullable = false, length = 10,unique = true)
    private BigInteger telefono;

    @Column(nullable = false)
    private String rol;

    @OneToOne(mappedBy = "id_empleado",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Usuario usuarios;

    public Empleado(BigInteger id, String nombre, String apellido, BigInteger telefono, String rol) {
        this.id = id;
        this.nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Empleado() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", telefono=" + telefono +
                ", rol='" + rol + '\'' +
                '}';
    }
}

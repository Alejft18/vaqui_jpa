package com.example.vaqui.Entidad;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "tbl_administrador")
public class Administrador {
    @Id
    @Column(nullable = false,length = 10, unique = true)
    private BigInteger id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String Apellido;

    @Column(nullable = false,length = 40)
    private String correo;

    @Column(nullable = false, length = 10, unique = true)
    private BigInteger telefono;

    @OneToOne(mappedBy = "id_administrador",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Usuario usuarios;

    public Administrador(BigInteger id, String nombre, String apellido, String correo, BigInteger telefono) {
        this.id = id;
        this.nombre = nombre;
        Apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Administrador() {
    }

    public BigInteger getId() {return id;}

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

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}

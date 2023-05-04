package com.example.vaqui.Entidad;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_general")
public class General {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 40)
    private String raza;
    @Column(nullable = false, length = 40)
    private String genero;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    @Column(nullable = false, length = 40)
    private String procedencia;

    @OneToMany(mappedBy = "tbl_general", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Lechera> tbl_lechera;

    @OneToMany(mappedBy = "tbl_general", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Secado> tbl_secado;

    @OneToMany(mappedBy = "tbl_general", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Gestacion> tbl_gestacion;

    @OneToMany(mappedBy = "tbl_general", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ternero> tbl_ternero;

    @OneToMany(mappedBy = "tbl_general", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Toro> tbl_toro;

    @OneToMany(mappedBy = "tbl_general", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Engorde> tbl_engorde;;

    public General(int id, String raza, String genero, Date fecha_nacimiento, String procedencia) {
        this.id = id;
        this.raza = raza;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.procedencia = procedencia;
    }

    public General() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Set<Lechera> getTbl_lechera() {
        return tbl_lechera;
    }

    public void setTbl_lechera(Set<Lechera> tbl_lechera) {
        this.tbl_lechera = tbl_lechera;
    }

    public Set<Secado> getTbl_secado() {
        return tbl_secado;
    }

    public void setTbl_secado(Set<Secado> tbl_secado) {
        this.tbl_secado = tbl_secado;
    }

    public Set<Gestacion> getTbl_gestacion() {
        return tbl_gestacion;
    }

    public void setTbl_gestacion(Set<Gestacion> tbl_gestacion) {
        this.tbl_gestacion = tbl_gestacion;
    }

    public Set<Ternero> getTbl_ternero() {
        return tbl_ternero;
    }

    public void setTbl_ternero(Set<Ternero> tbl_ternero) {
        this.tbl_ternero = tbl_ternero;
    }

    public Set<Toro> getTbl_toro() {
        return tbl_toro;
    }

    public void setTbl_toro(Set<Toro> tbl_toro) {
        this.tbl_toro = tbl_toro;
    }

    public Set<Engorde> getTbl_engorde() {
        return tbl_engorde;
    }

    public void setTbl_engorde(Set<Engorde> tbl_engorde) {
        this.tbl_engorde = tbl_engorde;
    }

    @Override
    public String toString() {
        return "General{" +
                "id=" + id +
                ", raza='" + raza + '\'' +
                ", genero='" + genero + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", procedencia='" + procedencia + '\'' +
                '}';
    }
}

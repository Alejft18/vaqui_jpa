package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_ternero")
public class Ternero {

    @Id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_terneros;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_madre", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_madre;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_Revision;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Ternero(General id_terneros, General id_madre, Double peso_kilos, Date fecha_Revision, String categoria) {
        this.id_terneros = id_terneros;
        this.id_madre = id_madre;
        this.peso_kilos = peso_kilos;
        this.fecha_Revision = fecha_Revision;
        this.categoria = categoria;
    }

    public Ternero() {
    }

    public General getId_terneros() {
        return id_terneros;
    }

    public void setId_terneros(General id_terneros) {
        this.id_terneros = id_terneros;
    }

    public General getId_madre() {
        return id_madre;
    }

    public void setId_madre(General id_madre) {
        this.id_madre = id_madre;
    }

    public Double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(Double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }

    public Date getFecha_Revision() {
        return fecha_Revision;
    }

    public void setFecha_Revision(Date fecha_Revision) {
        this.fecha_Revision = fecha_Revision;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Ternero{" +
                "id_terneros=" + id_terneros +
                ", id_madre=" + id_madre +
                ", peso_kilos=" + peso_kilos +
                ", fecha_Revision=" + fecha_Revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

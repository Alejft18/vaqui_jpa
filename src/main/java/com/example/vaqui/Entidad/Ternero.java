package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_ternero")
public class Ternero {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General tbl_general;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_madre", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General madre;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_Revision;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Ternero(General tbl_general, General madre, Double peso_kilos, Date fecha_Revision, String categoria) {
        this.tbl_general = tbl_general;
        this.madre = madre;
        this.peso_kilos = peso_kilos;
        this.fecha_Revision = fecha_Revision;
        this.categoria = categoria;
    }

    public Ternero() {
    }

    public General getTbl_general() {
        return tbl_general;
    }

    public void setTbl_general(General tbl_general) {
        this.tbl_general = tbl_general;
    }

    public General getMadre() {
        return madre;
    }

    public void setMadre(General madre) {
        this.madre = madre;
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
                "tbl_general=" + tbl_general +
                ", madre=" + madre +
                ", peso_kilos=" + peso_kilos +
                ", fecha_Revision=" + fecha_Revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

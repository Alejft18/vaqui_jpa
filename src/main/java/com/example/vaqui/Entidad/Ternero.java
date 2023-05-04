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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_madre;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_Revision;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Ternero(General tbl_general, int id, int id_madre, Double peso_kilos, Date fecha_Revision, String categoria) {
        this.tbl_general = tbl_general;
        this.id = id;
        this.id_madre = id_madre;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_madre() {
        return id_madre;
    }

    public void setId_madre(int id_madre) {
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
                "tbl_general=" + tbl_general +
                ", id=" + id +
                ", id_madre=" + id_madre +
                ", peso_kilos=" + peso_kilos +
                ", fecha_Revision=" + fecha_Revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

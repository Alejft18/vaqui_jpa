package com.example.vaqui.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_secado")
public class Secado {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General tbl_general;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_ultParto;

    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_revision;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_ordeño;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Secado(int id, Date fecha_ultParto, Double peso_kilos, Date fecha_revision, Date fecha_ordeño, String categoria) {
        this.id = id;
        this.fecha_ultParto = fecha_ultParto;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.fecha_ordeño = fecha_ordeño;
        this.categoria = categoria;
    }

    public Secado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_ultParto() {
        return fecha_ultParto;
    }

    public void setFecha_ultParto(Date fecha_ultParto) {
        this.fecha_ultParto = fecha_ultParto;
    }

    public Double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(Double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }

    public Date getFecha_revision() {
        return fecha_revision;
    }

    public void setFecha_revision(Date fecha_revision) {
        this.fecha_revision = fecha_revision;
    }

    public Date getFecha_ordeño() {
        return fecha_ordeño;
    }

    public void setFecha_ordeño(Date fecha_ordeño) {
        this.fecha_ordeño = fecha_ordeño;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Secado{" +
                "id=" + id +
                ", fecha_ultParto=" + fecha_ultParto +
                ", peso_kilos=" + peso_kilos +
                ", fecha_revision=" + fecha_revision +
                ", fecha_ordeño=" + fecha_ordeño +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
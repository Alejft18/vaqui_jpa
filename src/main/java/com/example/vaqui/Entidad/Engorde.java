package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_engorde")
public class Engorde {
    @Id
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_Engorde;
    @Column(nullable = false)
    private Double peso_kilos;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_Revision;
    @Column(nullable = false, length = 50)
    private String alimento;
    @Column(nullable = false, length = 20)
    private String categoria;

    public Engorde(General id_Engorde, Double peso_kilos, Date fecha_Revision, String alimento, String categoria) {
        this.id_Engorde = id_Engorde;
        this.peso_kilos = peso_kilos;
        this.fecha_Revision = fecha_Revision;
        this.alimento = alimento;
        this.categoria = categoria;
    }

    public Engorde() {
    }

    public General getId_Engorde() {
        return id_Engorde;
    }

    public void setId_Engorde(General id_Engorde) {
        this.id_Engorde = id_Engorde;
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

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Engorde{" +
                "id_Engorde=" + id_Engorde +
                ", peso_kilos=" + peso_kilos +
                ", fecha_Revision=" + fecha_Revision +
                ", alimento='" + alimento + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_gestacion")
public class Gestacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_gestacion;
    @Column(nullable = false)
    private Double peso_kilos;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_inseminacion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_aproxParto;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fecha_ultimoParto;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_Revision;
    @Column(nullable = false, length = 20)
    private String categoria;

    public Gestacion(General id_gestacion, Double peso_kilos, Date fecha_inseminacion, Date fecha_aproxParto, Date fecha_ultimoParto, Date fecha_Revision, String categoria) {
        this.id_gestacion = id_gestacion;
        this.peso_kilos = peso_kilos;
        this.fecha_inseminacion = fecha_inseminacion;
        this.fecha_aproxParto = fecha_aproxParto;
        this.fecha_ultimoParto = fecha_ultimoParto;
        this.fecha_Revision = fecha_Revision;
        this.categoria = categoria;
    }

    public Gestacion(Integer codigo, General id_gestacion, Double peso_kilos, Date fecha_inseminacion, Date fecha_aproxParto, Date fecha_ultimoParto, Date fecha_Revision, String categoria) {
        this.codigo = codigo;
        this.id_gestacion = id_gestacion;
        this.peso_kilos = peso_kilos;
        this.fecha_inseminacion = fecha_inseminacion;
        this.fecha_aproxParto = fecha_aproxParto;
        this.fecha_ultimoParto = fecha_ultimoParto;
        this.fecha_Revision = fecha_Revision;
        this.categoria = categoria;
    }

    public Gestacion() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_gestacion() {
        return id_gestacion;
    }

    public void setId_gestacion(General id_gestacion) {
        this.id_gestacion = id_gestacion;
    }

    public Double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(Double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }

    public Date getFecha_inseminacion() {
        return fecha_inseminacion;
    }

    public void setFecha_inseminacion(Date fecha_inseminacion) {
        this.fecha_inseminacion = fecha_inseminacion;
    }

    public Date getFecha_aproxParto() {
        return fecha_aproxParto;
    }

    public void setFecha_aproxParto(Date fecha_aproxParto) {
        this.fecha_aproxParto = fecha_aproxParto;
    }

    public Date getFecha_ultimoParto() {
        return fecha_ultimoParto;
    }

    public void setFecha_ultimoParto(Date fecha_ultimoParto) {
        this.fecha_ultimoParto = fecha_ultimoParto;
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
        return "Gestacion{" +
                "codigo=" + codigo +
                ", id_gestacion=" + id_gestacion +
                ", peso_kilos=" + peso_kilos +
                ", fecha_inseminacion=" + fecha_inseminacion +
                ", fecha_aproxParto=" + fecha_aproxParto +
                ", fecha_ultimoParto=" + fecha_ultimoParto +
                ", fecha_Revision=" + fecha_Revision +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

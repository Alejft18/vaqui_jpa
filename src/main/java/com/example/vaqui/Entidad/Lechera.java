package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_lechera")
public class Lechera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General id_lecheras;

    @Column(nullable = false)
    private Double litro_Producidos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_ordeno;
    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_revision;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_parto;

    @Column
    private int cant_partos;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Lechera(General id_lecheras, Double litro_Producidos, Date fecha_ordeno, Double peso_kilos, Date fecha_revision, Date fecha_parto, int cant_partos, String categoria) {
        this.id_lecheras = id_lecheras;
        this.litro_Producidos = litro_Producidos;
        this.fecha_ordeno = fecha_ordeno;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.fecha_parto = fecha_parto;
        this.cant_partos = cant_partos;
        this.categoria = categoria;
    }

    public Lechera(Integer codigo, General id_lecheras, Double litro_Producidos, Date fecha_ordeno, Double peso_kilos, Date fecha_revision, Date fecha_parto, int cant_partos, String categoria) {
        this.codigo = codigo;
        this.id_lecheras = id_lecheras;
        this.litro_Producidos = litro_Producidos;
        this.fecha_ordeno = fecha_ordeno;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.fecha_parto = fecha_parto;
        this.cant_partos = cant_partos;
        this.categoria = categoria;
    }

    public Lechera() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public General getId_lecheras() {
        return id_lecheras;
    }

    public void setId_lecheras(General id_lecheras) {
        this.id_lecheras = id_lecheras;
    }

    public Double getLitro_Producidos() {
        return litro_Producidos;
    }

    public void setLitro_Producidos(Double litro_Producidos) {
        this.litro_Producidos = litro_Producidos;
    }

    public Date getFecha_ordeno() {
        return fecha_ordeno;
    }

    public void setFecha_ordeno(Date fecha_ordeno) {
        this.fecha_ordeno = fecha_ordeno;
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

    public Date getFecha_parto() {
        return fecha_parto;
    }

    public void setFecha_parto(Date fecha_parto) {
        this.fecha_parto = fecha_parto;
    }

    public int getCant_partos() {
        return cant_partos;
    }

    public void setCant_partos(int cant_partos) {
        this.cant_partos = cant_partos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Lechera{" +
                "codigo=" + codigo +
                ", id_lecheras=" + id_lecheras +
                ", litro_Producidos=" + litro_Producidos +
                ", fecha_ordeño=" + fecha_ordeno +
                ", peso_kilos=" + peso_kilos +
                ", fecha_revision=" + fecha_revision +
                ", fecha_parto=" + fecha_parto +
                ", cant_partos=" + cant_partos +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
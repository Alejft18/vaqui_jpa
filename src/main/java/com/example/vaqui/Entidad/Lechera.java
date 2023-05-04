package com.example.vaqui.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_lechera")
public class Lechera
{

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private General tbl_general;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false)
    private Double litro_Producidos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_ordeño;
    @Column(nullable = false)
    private Double peso_kilos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_revision;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_parto;
    private int cant_partos;

    @Column(nullable = false, length = 20)
    private String categoria;

    public Lechera(int id, Double litro_Producidos, Date fecha_ordeño, Double peso_kilos, Date fecha_revision, Date fecha_parto, int cant_partos, String categoria) {
        this.id = id;
        this.litro_Producidos = litro_Producidos;
        this.fecha_ordeño = fecha_ordeño;
        this.peso_kilos = peso_kilos;
        this.fecha_revision = fecha_revision;
        this.fecha_parto = fecha_parto;
        this.cant_partos = cant_partos;
        this.categoria = categoria;
    }

    public Lechera() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLitro_Producidos() {
        return litro_Producidos;
    }

    public void setLitro_Producidos(Double litro_Producidos) {
        this.litro_Producidos = litro_Producidos;
    }

    public Date getFecha_ordeño() {
        return fecha_ordeño;
    }

    public void setFecha_ordeño(Date fecha_ordeño) {
        this.fecha_ordeño = fecha_ordeño;
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
                "id=" + id +
                ", litro_Producidos=" + litro_Producidos +
                ", fecha_ordeño=" + fecha_ordeño +
                ", peso_kilos=" + peso_kilos +
                ", fecha_revision=" + fecha_revision +
                ", fecha_parto=" + fecha_parto +
                ", cant_partos=" + cant_partos +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

@Entity
@Table

public class Inasistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int justificada;
    private Double cantidad;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    public Inasistencia(int justificada, Double cantidad, Estudiante estudiante, Tipo tipo) {
        this.justificada = justificada;
        this.cantidad = cantidad;
        this.estudiante = estudiante;
        this.tipo = tipo;
    }

    public Inasistencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJustificada() {
        return justificada;
    }

    public void setJustificada(int justificada) {
        this.justificada = justificada;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Inasistencia{" +
                "id=" + id +
                ", justificada=" + justificada +
                ", cantidad=" + cantidad +
                ", estudiante=" + estudiante.getNombre() +
                ", tipo=" + tipo.getNombre() +
                '}';
    }
}

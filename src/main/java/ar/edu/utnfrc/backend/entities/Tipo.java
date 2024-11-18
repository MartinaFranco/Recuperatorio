package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table

public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @OneToMany(mappedBy = "tipo")
    private List<Inasistencia> inasistencias;

    public Tipo(String nombre) {
        this.nombre = nombre;

    }

    public Tipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Inasistencia> getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(List<Inasistencia> inasistencias) {
        this.inasistencias = inasistencias;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", inasistencias=" + inasistencias +
                '}';
    }
}

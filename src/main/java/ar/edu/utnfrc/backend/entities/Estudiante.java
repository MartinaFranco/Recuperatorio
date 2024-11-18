package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @OneToMany(mappedBy = "estudiante")
    private List<Inasistencia> inasistencias;

    public Estudiante(String nombre) {
        this.nombre = nombre;

    }

    public Estudiante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inasistencia> getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(List<Inasistencia> inasistencias) {
        this.inasistencias = inasistencias;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", inasistencias=" + inasistencias +
                '}';
    }
}

package ar.edu.utnfrc.backend.service;

import ar.edu.utnfrc.backend.entities.Estudiante;
import ar.edu.utnfrc.backend.entities.Inasistencia;
import ar.edu.utnfrc.backend.entities.Tipo;
import ar.edu.utnfrc.backend.repository.InasistenciaRepository;

public class InasistenciaService implements IService<Inasistencia, Integer>{

    private InasistenciaRepository repository;

    public InasistenciaService() {
        repository = new InasistenciaRepository();
    }

    @Override
    public Inasistencia buscarBD(String name) {
        return null;
    }


    public Inasistencia cargarInasistencia(
            int justificada, Double cantidad, Estudiante estudiante, Tipo tipo
    ){
        Inasistencia inasistencia = new Inasistencia(justificada,cantidad,estudiante,tipo);
        repository.save(inasistencia);
        return inasistencia;

    }
}

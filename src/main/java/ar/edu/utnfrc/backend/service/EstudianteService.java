package ar.edu.utnfrc.backend.service;

import ar.edu.utnfrc.backend.entities.Estudiante;
import ar.edu.utnfrc.backend.repository.EstudianteRepository;

public class EstudianteService implements IService<Estudiante, Integer>{

    private EstudianteRepository repository;

    public EstudianteService() {
        repository = new EstudianteRepository();
    }

    @Override
    public Estudiante buscarBD(String name) {
       Estudiante resultado = repository.findByName(name);
       if(resultado==null){
           resultado = new Estudiante(name);
           repository.save(resultado);
       }
       return resultado;
    }
}

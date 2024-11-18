package ar.edu.utnfrc.backend.service;

import ar.edu.utnfrc.backend.entities.Estudiante;
import ar.edu.utnfrc.backend.entities.Tipo;
import ar.edu.utnfrc.backend.repository.TipoRepository;

public class TipoService implements IService<Tipo, Integer>{

    private TipoRepository repository;

    public TipoService() {
        repository = new TipoRepository();
    }

    @Override
    public Tipo buscarBD(String name) {
        Tipo resultado = repository.findByName(name);
        if(resultado==null){
            resultado = new Tipo(name);
            repository.save(resultado);
        }
        return resultado;
    }
}

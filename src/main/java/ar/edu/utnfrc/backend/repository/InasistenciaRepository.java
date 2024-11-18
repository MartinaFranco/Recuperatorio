package ar.edu.utnfrc.backend.repository;

import ar.edu.utnfrc.backend.repository.context.DbContext;
import ar.edu.utnfrc.backend.entities.Inasistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class InasistenciaRepository implements Repository<Inasistencia, Integer>{

    private EntityManager manager;

    public InasistenciaRepository() {
        this.manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Inasistencia entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public Inasistencia findById(Integer id) {
        try {
            return manager.find(Inasistencia.class,id);

        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public List<Inasistencia> findAll() {
        TypedQuery<Inasistencia> query = manager.createQuery("SELECT i FROM Inasistencia i", Inasistencia.class);
        return query.getResultList();
    }

    @Override
    public void update(Inasistencia entity) {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Inasistencia inasistencia=findById(id);
        manager.getTransaction().begin();
        manager.remove(inasistencia);
        manager.getTransaction().commit();
    }
}

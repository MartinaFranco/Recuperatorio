package ar.edu.utnfrc.backend.repository;

import ar.edu.utnfrc.backend.repository.context.DbContext;
import ar.edu.utnfrc.backend.entities.Tipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TipoRepository implements Repository<Tipo, Integer>{

    private EntityManager manager;

    public TipoRepository() {
        this.manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Tipo entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public Tipo findById(Integer id) {
        try {
            return manager.find(Tipo.class,id);

        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public List<Tipo> findAll() {
        TypedQuery<Tipo> query = manager.createQuery("SELECT t FROM Tipo t", Tipo.class);
        return query.getResultList();
    }

    @Override
    public void update(Tipo entity) {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Tipo tipo=findById(id);
        manager.getTransaction().begin();
        manager.remove(tipo);
        manager.getTransaction().commit();
    }

    public Tipo findByName(String name){
        try {
            String jpql = "SELECT t FROM Tipo t WHERE t.nombre=:nombre";
            return (Tipo) manager.createQuery(jpql , Tipo.class).setParameter("nombre",name).getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }
}

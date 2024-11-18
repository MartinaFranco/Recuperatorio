package ar.edu.utnfrc.backend.repository;

import ar.edu.utnfrc.backend.repository.context.DbContext;
import ar.edu.utnfrc.backend.entities.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EstudianteRepository implements Repository<Estudiante,Integer>{

    private EntityManager manager;

    public EstudianteRepository() {
        this.manager = DbContext.getInstance().getManager();
    }

    @Override
    public void save(Estudiante entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public Estudiante findById(Integer id) {
        try {
            return manager.find(Estudiante.class,id);

        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public List<Estudiante> findAll() {
        TypedQuery<Estudiante> query = manager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public void update(Estudiante entity) {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Estudiante estudiante=findById(id);
        manager.getTransaction().begin();
        manager.remove(estudiante);
        manager.getTransaction().commit();
    }

    public Estudiante findByName(String name){
        try {
            String jpql = "SELECT e FROM Estudiante e WHERE e.nombre=:nombre";
            return (Estudiante) manager.createQuery(jpql , Estudiante.class).setParameter("nombre",name).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }


}

package ar.edu.utnfrc.backend.repository;

import java.util.List;

public interface Repository <T,k>{
    void save(T entity);
    T findById(k id);
    List<T> findAll();
    void update(T entity);
    void delete(k id);

}

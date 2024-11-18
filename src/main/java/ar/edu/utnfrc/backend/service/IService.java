package ar.edu.utnfrc.backend.service;

public interface IService <T ,k >{
    //crear servicio de guardar, este verifica si ya esta creado o no
    T buscarBD(String name);
}

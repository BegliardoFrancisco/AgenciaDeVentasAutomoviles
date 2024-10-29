package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import java.util.List;

public interface ModelsRepository<T> {

    List<T> getall();
    T getid(int id);
    void create(T model);
    void delete(int id);
    void update( T model);

}

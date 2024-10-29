package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import java.util.List;

public interface TestingRepository<T> {
    List<T> getall();
    T getid(int id);
    void create(T testing);
    void delete(int id);
    void update( T testing);

}

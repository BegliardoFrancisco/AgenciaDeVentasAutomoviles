package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import java.util.List;

public interface PositionRepository<T> {

    List<T> getall();
    T getid(int id);
    void create(T position);
    void delete(int id);
    void update( T position);

}
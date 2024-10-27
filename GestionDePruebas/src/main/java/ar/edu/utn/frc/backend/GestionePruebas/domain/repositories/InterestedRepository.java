package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import java.util.List;


public interface InterestedRepository<T> {

    List<T> getall();
    T getid(int id);
    void create(T interested);
    void delete(int id);
    void update( T interested);

}


package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;

import java.util.List;

public interface EmpleadoRepository<T> {

    List<T> getall();
    T getid(int id);
    void create(T employes);
    void delete(int id);
    void update( T employes);
}

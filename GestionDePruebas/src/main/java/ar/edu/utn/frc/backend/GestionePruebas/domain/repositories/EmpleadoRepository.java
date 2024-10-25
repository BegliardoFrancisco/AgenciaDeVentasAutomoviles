package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;

import java.util.List;

public interface EmpleadoRepository {

    List<Employes> getall();
    Employes getid(int id);
    void create(Employes employes);
    void delete(int id);
    void update( Employes employes);
}

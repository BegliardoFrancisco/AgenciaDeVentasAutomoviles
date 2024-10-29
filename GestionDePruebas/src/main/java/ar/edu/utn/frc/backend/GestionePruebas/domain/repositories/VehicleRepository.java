package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import java.util.List;

public interface VehicleRepository<T> {
    List<T> getall();
    T getid(int id);
    void create(T vehicle);
    void delete(int id);
    void update( T vehicle);

}

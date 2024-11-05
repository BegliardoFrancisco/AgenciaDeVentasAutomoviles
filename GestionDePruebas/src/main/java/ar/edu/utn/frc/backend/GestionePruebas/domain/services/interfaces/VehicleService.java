package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.List;

public interface VehicleService<T> {
    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);
    public void create(int id, String patente, int model_id, int anio);
    public void update(int id, String patente, int model_id, int anio);
}

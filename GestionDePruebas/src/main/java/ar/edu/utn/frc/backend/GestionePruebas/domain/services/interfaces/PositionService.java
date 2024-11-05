package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.Date;
import java.util.List;

public interface PositionService<T>{
    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);
    public void create(int id, int vehicle_id, Date date_hour, int latitude, int longitude);
    public void update(int id, int vehicle_id, Date date_hour, int latitude, int longitude);
}

package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.Date;
import java.util.List;

public interface TestingService<T>{
    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);
    public void create(int id, int vehicle_id, int interested_id, int employed_id,
                       Date date_hs_init, Date date_hs_finish, String feedback);
    public void update(int id, int vehicle_id, int interested_id, int employed_id,
                       Date date_hs_init, Date date_hs_finish, String feedback);
}

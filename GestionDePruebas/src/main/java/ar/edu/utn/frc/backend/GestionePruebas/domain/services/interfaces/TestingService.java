package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TestingService<T>{
    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);
    public void create(int id, int vehicle_id, int interested_id, int employed_id,
                       Date date_hs_init, Optional<Date> date_hs_finish, Optional<String> feedback);
    public void update(int id, int vehicle_id, int interested_id, int employed_id,
                       Date date_hs_init, Optional<Date> date_hs_finish, Optional<String> feedback);
    public void finish(int id, Date date_hs_finish, String feedback);
}

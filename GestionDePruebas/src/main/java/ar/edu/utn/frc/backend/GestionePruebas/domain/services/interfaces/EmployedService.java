package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.List;

public interface EmployedService<T>  {

    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);
    public void create( int id, String name, String surname, int phoneNumber);
    public void update( int id, String name, String surname, int phoneNumber);

}

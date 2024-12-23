package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.List;

public interface ModelsService<T> {
    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);
    public void create(int id, String name, int company);
    public void update(int id, String newName, int newCompany);

}

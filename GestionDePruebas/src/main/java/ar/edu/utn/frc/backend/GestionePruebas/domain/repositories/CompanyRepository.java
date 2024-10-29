package ar.edu.utn.frc.backend.GestionePruebas.domain.repositories;

import java.util.List;

public interface CompanyRepository<T>{

    List<T> getall();
    T getid(int id);
    void create(T company);
    void delete(int id);
    void update( T company);

}

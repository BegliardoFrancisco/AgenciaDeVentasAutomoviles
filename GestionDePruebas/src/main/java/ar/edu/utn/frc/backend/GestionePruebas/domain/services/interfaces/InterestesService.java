package ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces;

import java.util.Date;
import java.util.List;

public interface InterestesService<T> {

    public List<T> getall();
    public T getid(Integer id);
    public T delete(Integer id);

    public void create( int id,String type_document, String nro_document,
                        String name, String surname, Boolean restricted,
                        int licenseNumber, Date licenseExpirationDate);

    public void update( int id,String type_document, String nro_document,
                        String name, String surname, Boolean restricted,
                        int licenseNumber, Date licenseExpirationDate);

}

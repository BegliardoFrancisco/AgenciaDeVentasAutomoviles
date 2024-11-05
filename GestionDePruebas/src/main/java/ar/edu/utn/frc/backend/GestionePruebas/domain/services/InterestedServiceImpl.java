package ar.edu.utn.frc.backend.GestionePruebas.domain.services;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.InterestedRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.InterestedService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Service
public class InterestedServiceImpl implements InterestedService<Interested> {

    private final InterestedRepository<Interested> interestedRepository;


    @Override
    public List<Interested> getall() {
        return List.of();
    }

    @Override
    public Interested getid(Integer id) {
        return null;
    }

    @Override
    public Interested delete(Integer id) {
        return null;
    }

    @Override
    public void create(int id, String type_document, String nro_document, String name, String surname, Boolean restricted, int licenseNumber, Date licenseExpirationDate) {

    }

    @Override
    public void update(int id, String type_document, String nro_document, String name, String surname, Boolean restricted, int licenseNumber, Date licenseExpirationDate) {

    }
}

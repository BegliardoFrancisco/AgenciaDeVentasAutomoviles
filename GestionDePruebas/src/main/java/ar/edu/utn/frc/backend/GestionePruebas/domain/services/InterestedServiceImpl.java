package ar.edu.utn.frc.backend.GestionePruebas.domain.services;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.InterestedRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.InterestedService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@AllArgsConstructor
@Service
public class InterestedServiceImpl implements InterestedService<Interested> {

    private final InterestedRepository<Interested> interestedRepository;


    @Override
    public List<Interested> getall() {
        return this.interestedRepository.getall();
    }

    @Override
    public Interested getid(Integer id) {
        return this.interestedRepository.getid(id);
    }

    @Override
    public Interested delete(Integer id) throws NoSuchElementException {
        Interested interested = this.getid(id);
        this.interestedRepository.delete(id);
        return interested;
    }

    @Override
    public void create(int id, String type_document, String nro_document, String name, String surname, Boolean restricted, int licenseNumber, Date licenseExpirationDate) {
        Interested newinterested = new Interested(id, type_document,nro_document ,name, surname, restricted, licenseNumber, licenseExpirationDate);
        this.interestedRepository.create(newinterested);
    }

    @Override
    public void update(int id, String type_document, String nro_document, String name, String surname,
                       Boolean restricted, int licenseNumber, Date licenseExpirationDate)
            throws NoSuchElementException {

        Interested interested = this.getid(id);

        interested.setTypeDocument(type_document);
        interested.setNroDocument(nro_document);
        interested.setName(name);
        interested.setSurname(surname);
        interested.setRestricted(restricted);
        interested.setLicenseNumber(licenseNumber);
        interested.setLicenseExpirationDate(licenseExpirationDate);

        this.interestedRepository.update(interested);
    }





}

package ar.edu.utn.frc.backend.GestionePruebas.domain.services;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.EmpleadoRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.EmpleadoService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class EmpleadoServiceImpl implements EmpleadoService<Employes> {

    private final EmpleadoRepository<Employes> empleadoRepository;


    public List<Employes> getall() {

        List<Employes> response = this.empleadoRepository.getall();
        if (response.isEmpty()) {
            throw new NoSuchElementException("No se encuentran elementos");
        }
        return response;
    }

    public Employes getid(Integer id) {
        return this.empleadoRepository.getid(id);

    }


    public Employes delete(Integer id) throws NoSuchElementException {

        Employes employed = this.getid(id);

        this.empleadoRepository.delete(id);

        return employed;
    }

    @Override
    public void create(int id, String name, String surname, int phoneNumber) {

        Employes employed = new Employes(id,name,surname,phoneNumber);

        this.empleadoRepository.create(employed);

    }

    @Override
    public void update(int id, String name, String surname, int phoneNumber) throws  NoSuchElementException {
            Employes employed = this.getid(id);

            employed.setName(name);
            employed.setSurname(surname);
            employed.setPhoneContact(phoneNumber);

            this.empleadoRepository.create(employed);


    }

}

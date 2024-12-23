package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.EmpleadoRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.EmployesDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@RequiredArgsConstructor
public class EmployesRepositoryImpl implements EmpleadoRepository<Employes> {

    private final EmployesDAO employesDAO;

    @Override
    public List<Employes> getall() {
        return this.employesDAO.findAll();
    }

    @Override
    public Employes getid(int id) {
        return this.employesDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Employes employes) {
        this.employesDAO.save(employes);
    }

    @Override
    public void delete(int id) {

        this.employesDAO.deleteById(id);

    }

    @Override
    public void update(Employes employes) {

        this.employesDAO.save(employes);
    }
}

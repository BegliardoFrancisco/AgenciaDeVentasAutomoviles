package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.TestingRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.TestingDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Testing;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TestingRepositoryImpl implements TestingRepository<Testing> {

    private final TestingDAO testingDAO;

    @Override
    public List<Testing> getall() {
        return this.testingDAO.findAll();
    }

    @Override
    public Testing getid(int id) {
        return this.testingDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Testing testing) {
        this.testingDAO.save(testing);
    }

    @Override
    public void delete(int id) {
        this.testingDAO.deleteById(id);
    }

    @Override
    public void update(Testing testing) {
        this.testingDAO.save(testing);
    }
}

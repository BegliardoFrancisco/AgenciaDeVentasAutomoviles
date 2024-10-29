package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.ModelsRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.ModelsDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Models;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ModelsRepositoryImpl implements ModelsRepository<Models> {

    private final ModelsDAO modelsDAO;

    @Override
    public List<Models> getall() {
        return this.modelsDAO.findAll();
    }

    @Override
    public Models getid(int id) {
        return this.modelsDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Models model) {
        this.modelsDAO.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelsDAO.deleteById(id);
    }

    @Override
    public void update(Models model) {
        this.modelsDAO.save(model);
    }
}

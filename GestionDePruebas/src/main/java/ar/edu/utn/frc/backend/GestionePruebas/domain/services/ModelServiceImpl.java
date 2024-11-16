package ar.edu.utn.frc.backend.GestionePruebas.domain.services;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.ModelsRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.CompanyService;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.ModelsService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Company;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Models;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelsService<Models> {

    private final ModelsRepository<Models> modelsRepository;
    private final CompanyService<Company> companyService;

    @Override
    public List<Models> getall() {
        return this.modelsRepository.getall();
    }

    @Override
    public Models getid(Integer id) throws NoSuchElementException {
        return this.modelsRepository.getid(id);
    }

    @Override
    public Models delete(Integer id) throws  NoSuchElementException {
        Models model = this.getid(id);

        this.modelsRepository.delete(id);

        return model;
    }

    @Override
    public void create(int id, String name, int company) throws NoSuchElementException{

        Company companyfromModel = this.companyService.getid(company);

        Models model = new Models(id, companyfromModel,name);

    }

    @Override
    public void update(int id, String newName, int newCompany) {
        Models model = this.getid(id);
        Company companyfromModel = this.companyService.getid(newCompany);

        model.setCompany(companyfromModel);
        model.setDescription(newName);

        this.modelsRepository.update(model);
    }
}

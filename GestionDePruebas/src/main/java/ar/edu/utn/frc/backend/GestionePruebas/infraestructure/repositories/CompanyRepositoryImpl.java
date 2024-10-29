package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.CompanyRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.CompanyDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository<Company> {

    private final CompanyDAO companyDAO;

    @Override
    public List<Company> getall() {
        return this.companyDAO.findAll();
    }

    @Override
    public Company getid(int id) {
        return this.companyDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Company company) {
        this.companyDAO.save(company);
    }

    @Override
    public void delete(int id) {
        this.companyDAO.deleteById(id);
    }

    @Override
    public void update(Company company) {
        this.companyDAO.save(company);
    }
}

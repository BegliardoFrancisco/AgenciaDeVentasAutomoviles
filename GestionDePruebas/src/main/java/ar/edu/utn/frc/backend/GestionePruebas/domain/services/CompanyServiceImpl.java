package ar.edu.utn.frc.backend.GestionePruebas.domain.services;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.CompanyRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.CompanyService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService<Company> {

    private final CompanyRepository<Company> companyRepository;

    @Override
    public List<Company> getall() {
        return this.companyRepository.getall();
    }

    @Override
    public Company getid(Integer id) throws NoSuchElementException {
        return this.companyRepository.getid(id);
    }

    @Override
    public Company delete(Integer id) throws NoSuchElementException {
        Company company = this.getid(id);
        this.companyRepository.delete(id);
        return company;
    }

    @Override
    public void create(int id, String name){
        Company company = new Company(id, name);

        this.companyRepository.create(company);
    }

    @Override
    public void update(int id, String newName) {
        Company company = this.getid(id);
        company.setName(newName);
        this.companyRepository.update(company);
    }
}

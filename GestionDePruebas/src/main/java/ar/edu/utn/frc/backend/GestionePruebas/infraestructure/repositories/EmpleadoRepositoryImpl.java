package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.EmpleadoRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.EmpleadoDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoRepositoryImpl(EmpleadoDAO dao) {
        this.empleadoDAO = dao;
    }


    @Override
    public List<Employes> getall() {
        return this.empleadoDAO.findAll();
    }

    @Override
    public Employes getid(int id) {
        return this.empleadoDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Employes employes) {
        this.empleadoDAO.save(employes);
    }

    @Override
    public void delete(int id) {

        this.empleadoDAO.deleteById(id);

    }

    @Override
    public void update(Employes employes) {

        this.empleadoDAO.save(employes);
    }
}

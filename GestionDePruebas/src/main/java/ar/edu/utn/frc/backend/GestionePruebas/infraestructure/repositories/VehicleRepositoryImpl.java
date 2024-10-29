package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.VehicleRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.VehicleDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepository<Vehicle> {

    private final VehicleDAO vehicleDAO;


    @Override
    public List<Vehicle> getall() {
        return this.vehicleDAO.findAll();
    }

    @Override
    public Vehicle getid(int id) {
        return this.vehicleDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Vehicle vehicle) {

        this.vehicleDAO.save(vehicle);
    }

    @Override
    public void delete(int id) {
        this.vehicleDAO.deleteById(id);
    }

    @Override
    public void update(Vehicle vehicle) {
        this.vehicleDAO.save(vehicle);
    }

}

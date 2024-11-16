package ar.edu.utn.frc.backend.GestionePruebas.domain.services;


import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.VehicleRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.ModelsService;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.VehicleService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Models;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService<Vehicle> {

    private final VehicleRepository<Vehicle> vehicleRepository;
    private final ModelsService<Models> modelsService;

    @Override
    public List<Vehicle> getall() {
        return this.vehicleRepository.getall();
    }

    @Override
    public Vehicle getid(Integer id) throws  NoSuchElementException {
        return this.vehicleRepository.getid(id);

    }

    @Override
    public Vehicle delete(Integer id) throws NoSuchElementException {
        Vehicle vehicle = this.getid(id);

        this.vehicleRepository.delete(id);

        return vehicle;
    }

    @Override
    public void create(int id, String patente, int model_id, int anio) {

        Models model = this.modelsService.getid(model_id);
        Vehicle new_vehicle = new Vehicle(id, patente, model, anio);

    }

    @Override
    public void update(int id, String patente, int model_id, int anio) {

        Models model = this.modelsService.getid(model_id);
        Vehicle vehicle = this.getid(id);

        vehicle.setPatent(patente);
        vehicle.setModels(model);
        vehicle.setAnio(anio);

        this.vehicleRepository.update(vehicle);
    }
}

package ar.edu.utn.frc.backend.GestionePruebas.domain.services;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.TestingRepository;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.EmployedService;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.InterestedService;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.TestingService;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.VehicleService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Testing;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TestingServiceImpl implements TestingService<Testing> {

    private final TestingRepository<Testing> testingRepository;
    private final EmployedService<Employes> employedService;
    private final VehicleService<Vehicle> vehicleService;
    private final InterestedService<Interested> interestedService;


    @Override
    public List<Testing> getall() {
        return this.testingRepository.getall();
    }

    @Override
    public Testing getid(Integer id) throws NoSuchElementException {
        return this.testingRepository.getid(id);
    }

    @Override
    public Testing delete(Integer id) throws NoSuchElementException{
        Testing testing = this.getid(id);
        this.testingRepository.delete(id);
        return testing;
    }

    @Override
    public void create(int id, int vehicle_id, int interested_id,
                       int employed_id, Date date_hs_init, Optional<Date> date_hs_finish,
                       Optional<String> feedback) {

        if (this.testingRepository.avaibleEmployed(employed_id)){
            throw new IllegalArgumentException("The employee who wants to enter is already in a trial.");
        } else if (this.testingRepository.avaibleInterested(interested_id)) {
            throw new IllegalArgumentException("The interested who wants to enter is already in a trial.");
        } else if (this.testingRepository.avaibleVehicle(vehicle_id)) {
            throw new IllegalArgumentException("The vehicle who wants to enter is already in a trial.");
        }

        Employes employes = this.employedService.getid(employed_id);
        Interested interested = this.interestedService.getid(interested_id);
        Vehicle vehicle = this.vehicleService.getid(vehicle_id);

        Testing testing = new Testing(id,vehicle,interested,employes,date_hs_init,
                date_hs_finish.orElse(null),feedback.orElse(null));
        this.testingRepository.create(testing);


    }


    @Override
    public void update(int id, int vehicle_id, int interested_id, int employed_id, Date date_hs_init,
                       Optional<Date> date_hs_finish, Optional<String> feedback) {

        Employes employes = this.employedService.getid(employed_id);
        Interested interested = this.interestedService.getid(interested_id);
        Vehicle vehicle = this.vehicleService.getid(vehicle_id);

        Testing testing = this.getid(id);
        testing.update(vehicle,interested,employes,date_hs_init,
                date_hs_finish,feedback);
        this.testingRepository.create(testing);
    }

    @Override
    public void finish(int id, Date date_hs_finish, String feedback) {

        Testing testing = this.getid(id);

        testing.finish(date_hs_finish,feedback);

    }
}

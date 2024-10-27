package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.InterestedRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.InterestedDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@AllArgsConstructor
public class InterestedRepositoryImpl implements InterestedRepository<Interested> {

    private final InterestedDAO interestedDAO;

    @Override
    public List<Interested> getall() {
        return this.interestedDAO.findAll();
    }

    @Override
    public Interested getid(int id) {
        return this.interestedDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Interested interested) {
        this.interestedDAO.save(interested);
    }

    @Override
    public void delete(int id) {
        this.interestedDAO.deleteById(id);
    }

    @Override
    public void update(Interested interested) {

        this.interestedDAO.save(interested);


    }
}

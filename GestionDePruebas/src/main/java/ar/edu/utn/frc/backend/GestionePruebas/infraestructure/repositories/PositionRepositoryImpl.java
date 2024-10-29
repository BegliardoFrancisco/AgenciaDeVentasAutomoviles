package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.repositories;

import ar.edu.utn.frc.backend.GestionePruebas.domain.repositories.PositionRepository;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs.PositionDAO;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Position;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PositionRepositoryImpl implements PositionRepository<Position> {

    private final PositionDAO positionDAO;

    @Override
    public List<Position> getall() {
        return this.positionDAO.findAll();
    }

    @Override
    public Position getid(int id) {
        return this.positionDAO.findById(id).orElseThrow();
    }

    @Override
    public void create(Position position) {

        this.positionDAO.save(position);

    }

    @Override
    public void delete(int id) {

        this.positionDAO.deleteById(id);

    }

    @Override
    public void update(Position position) {

        this.positionDAO.save(position);

    }


}

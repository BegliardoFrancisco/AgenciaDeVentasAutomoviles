package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs;

import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestedDAO extends JpaRepository<Interested,Integer> {

}

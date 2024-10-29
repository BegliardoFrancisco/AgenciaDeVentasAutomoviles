package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Position extends JpaRepository<Position,Integer> {
}

package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Modelos")
public class Models {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA")
    Company company;

    @Column(name = "DESCRIPCION")
    String description;





}

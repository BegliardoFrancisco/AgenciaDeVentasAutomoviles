package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vehiculos")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "ID")
    int id;

    @Column(name=  "PATENTE")
    String patent;


    @OneToOne(mappedBy = "vehicle")
            @JoinColumn(name = "ID_MODELO")
    Models models;

    @Column(name = "ANIO")
    int anio;
}

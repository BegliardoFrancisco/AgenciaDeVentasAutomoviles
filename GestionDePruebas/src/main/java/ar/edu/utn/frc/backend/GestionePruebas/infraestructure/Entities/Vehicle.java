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


    @OneToOne
            @JoinColumn(name="models_id")
    Models models;

    @Column(name = "ANIO")
    int año;
}

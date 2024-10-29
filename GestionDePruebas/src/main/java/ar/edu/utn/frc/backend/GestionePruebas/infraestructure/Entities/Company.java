package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Marcas")
public class Company {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name= "NOMBRE")
    String name;

    @OneToMany(mappedBy = "company")
    List<Models> models = new ArrayList<>();

}

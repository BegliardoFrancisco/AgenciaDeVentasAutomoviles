package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Interesados")
public class Interested {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "TIPO_DOCUMENTO")
    int typeDocument;
    @Column(name = "DOCUMENTO")
    int nroDocument;
    @Column(name = "NOMBRE")
    String name;
    @Column(name = "APELLIDO")
    String surname;
    @Column(name = "RESTRINGIDO")
    Boolean restricted;
    @Column(name = "NRO_LICENCIA")
    int licenseNumber;
    @Column(name = "FECHA_VENCIMIENTO_LICENCIA")
    Date licenseExpirationDate;

}

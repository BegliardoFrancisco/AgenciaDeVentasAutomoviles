package ar.edu.utn.frc.backend.GestionePruebas.application.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class InterestedRequest {
    int id;
    String type_document;
    String nro_document;

    String name;
    String surname;
    Boolean restricted;

    int licenseNumber;
    Date licenseExpirationDate;
}

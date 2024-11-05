package ar.edu.utn.frc.backend.GestionePruebas.application.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestedRequestUpdate {

    String type_document;
    String nro_document;

    String name;
    String surname;
    Boolean restricted;

    int licenseNumber;
    Date licenseExpirationDate;


}

package ar.edu.utn.frc.backend.GestionePruebas.application.responses;


import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestedResponse {

    int id;
    String name;
    Boolean restricted;
    int licenseNumber;
    Date licenseExpirationDate;

    public static InterestedResponse from(Interested interested) {
        return new InterestedResponse(
                interested.getId(),
                interested.getName(),
                interested.getRestricted(),
                interested.getLicenseNumber(),
                interested.getLicenseExpirationDate()
        );
    }
}

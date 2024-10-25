package ar.edu.utn.frc.backend.GestionePruebas.application.responses;

import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import lombok.Data;

@Data
public class EmployesResponse {
    int id;
    String name;
    String surname;
    int phoneContact;

    public EmployesResponse() {}

    public EmployesResponse(int id, String name, String surname, int phoneContact) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneContact = phoneContact;
    }

    public static EmployesResponse from(Employes empleado) {

        return new EmployesResponse(
                empleado.getId(),
                empleado.getName(),
                empleado.getSurname(),
                empleado.getPhoneContact()
        );
    }
}

package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Empleados")
public class Employes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAJO")
    int  id;

    @Column(name= "NOMBRE")
    String name;

    @Column(name = "APELLIDO")
    String surname;

    @Column(name= "TELEFONO_CONTACTO")
    Integer phoneContact;



}

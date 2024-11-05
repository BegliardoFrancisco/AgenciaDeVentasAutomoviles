package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Posiciones")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;


    @OneToOne
            @JoinColumn(name = "ID_VEHICULO")
    Vehicle vehicle;

    @Column(name = "FECHA_HORA")
    Date date_hour;

    @Column(name = "LATITUD")
    Integer latitude;

    @Column(name = "LONGITUD")
    Integer longitude;

}

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

    @Column(name = "id_vehicle")
    @OneToOne
            @JoinColumn(name = "id_vehicle")
    Vehicle vehicle;

    @Column(name = "FECHA_HORA")
    Date date_hour;

    @Column(name = "LATITUD")
    Integer latitude;

    @Column(name = "LONGITUD")
    Integer longitude;

}

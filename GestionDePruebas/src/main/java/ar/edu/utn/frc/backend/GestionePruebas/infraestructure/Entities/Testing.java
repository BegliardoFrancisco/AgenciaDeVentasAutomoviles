package ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pruebas")
public class Testing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "vehicule_id")
    Vehicle vehicle;

    @OneToOne
    @JoinColumn(name="interested_id")
    Interested interested;

    @OneToOne
    @JoinColumn(name = "employed_id")
    Employes employed;

    @Column(name="FECHA_HORA_INICIO")
    Date date_hs_init;

    @Column(name="FECHA_HORA_FIN")
    Date date_hs_finish;

    @Column(name="COMENTARIOS")
    String feedback;

}

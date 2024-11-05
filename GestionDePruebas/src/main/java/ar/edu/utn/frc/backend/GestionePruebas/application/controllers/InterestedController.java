package ar.edu.utn.frc.backend.GestionePruebas.application.controllers;

import ar.edu.utn.frc.backend.GestionePruebas.application.requests.EmployedRequest;
import ar.edu.utn.frc.backend.GestionePruebas.application.requests.EmployedRequestUpdate;
import ar.edu.utn.frc.backend.GestionePruebas.application.requests.InterestedRequest;
import ar.edu.utn.frc.backend.GestionePruebas.application.requests.InterestedRequestUpdate;
import ar.edu.utn.frc.backend.GestionePruebas.application.responses.EmployesResponse;
import ar.edu.utn.frc.backend.GestionePruebas.application.responses.InterestedResponse;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.InterestedService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Interested;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/interested")
public class InterestedController {

    private final InterestedService<Interested> interestedService;


    @GetMapping
    public ResponseEntity<List<InterestedResponse>> getall() {
        try {
            List<InterestedResponse> response = this.interestedService
                    .getall()
                    .stream()
                    .map(InterestedResponse::from)
                    .toList();
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        }
    }


    @GetMapping
    public  ResponseEntity<InterestedResponse> getid (@PathVariable("id") int id) {
        try {
            InterestedResponse response = InterestedResponse.from(this.interestedService.getid(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(new InterestedResponse(), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addInterested(@RequestBody InterestedRequest interested) {
        try {
            this.interestedService.create(interested.getId(), interested.getType_document(),
                    interested.getNro_document(), interested.getName(),
                    interested.getSurname(), interested.getRestricted(),
                    interested.getLicenseNumber(), interested.getLicenseExpirationDate());

            return new ResponseEntity<>("menssage: Successful insertion", HttpStatus.OK);
        } catch (ClassCastException ex) {

            return new ResponseEntity<>("menssage: Invalid Request", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InterestedResponse> deleteInterested(@PathVariable("id") int id) {
        try {

            Interested interested = this.interestedService.delete(id);

            return new ResponseEntity<>(InterestedResponse.from(interested), HttpStatus.OK);

        } catch (NoSuchElementException ex){

            return new ResponseEntity<>(new InterestedResponse(), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInterested(@PathVariable("id") int id, @RequestBody InterestedRequestUpdate interested) {
        try {

            this.interestedService.update(id,interested.getType_document(),
                    interested.getNro_document(), interested.getName(),
                    interested.getSurname(), interested.getRestricted(),
                    interested.getLicenseNumber(), interested.getLicenseExpirationDate());

            return ResponseEntity.ok("{menssage: 'Successful update'}");

        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);

        }
    }


}

package ar.edu.utn.frc.backend.GestionePruebas.application.controllers;


import ar.edu.utn.frc.backend.GestionePruebas.application.requests.EmployedRequest;
import ar.edu.utn.frc.backend.GestionePruebas.application.requests.EmployedRequestUpdate;
import ar.edu.utn.frc.backend.GestionePruebas.application.responses.EmployesResponse;
import ar.edu.utn.frc.backend.GestionePruebas.domain.services.interfaces.EmpleadoService;
import ar.edu.utn.frc.backend.GestionePruebas.infraestructure.Entities.Employes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employes")
public class EmployesController {

    private final EmpleadoService<Employes> empleadoService;

    @GetMapping
    public ResponseEntity<List<EmployesResponse>> getall() {
        try {
            List<EmployesResponse> response = this.empleadoService
                    .getall()
                    .stream()
                    .map(EmployesResponse::from)
                    .toList();

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployesResponse> getid(@PathVariable("id") int id) {

        try {
            EmployesResponse response = EmployesResponse.from(this.empleadoService.getid(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(new EmployesResponse(), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addEmployed(@RequestBody EmployedRequest employed) {
        try {
            this.empleadoService.create(employed.getId(), employed.getName(),
                    employed.getSurname(), employed.getPhoneContact());

            return new ResponseEntity<>("menssage: Successful insertion", HttpStatus.OK);
        } catch (ClassCastException ex) {

            return new ResponseEntity<>("menssage: Invalid Request", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployesResponse> deleteEmployed(@PathVariable("id") int id) {
        try {

            Employes employed = this.empleadoService.delete(id);

            return new ResponseEntity<>(EmployesResponse.from(employed), HttpStatus.OK);

        } catch (NoSuchElementException ex){

            return new ResponseEntity<>(new EmployesResponse(), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployed(@PathVariable("id") int id, @RequestBody EmployedRequestUpdate employed) {
        try {

            this.empleadoService.update(id, employed.getName(), employed.getSurname(), employed.getPhoneContact());

            return ResponseEntity.ok("{menssage: 'Successful update'}");

        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);

        }
    }



}

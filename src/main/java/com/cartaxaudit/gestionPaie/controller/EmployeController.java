package com.cartaxaudit.gestionPaie.controller;

import com.cartaxaudit.gestionPaie.entity.Employe;
import com.cartaxaudit.gestionPaie.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "employes")
@AllArgsConstructor
public class EmployeController {
    private EmployeService employeService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Employe employe) {
        employeService.create(employe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        List<Employe> allEmploye = employeService.getAll();
        return ResponseEntity.ok(allEmploye);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Employe employe = employeService.get(id);
        return ResponseEntity.ok(employe);
    }

//    @PostMapping("{id}/conges")
//    public ResponseEntity<?> addCongeToEmploye(@PathVariable int id, ) {
//
//    }
}

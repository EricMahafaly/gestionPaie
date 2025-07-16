package com.cartaxaudit.gestionPaie.service;

import com.cartaxaudit.gestionPaie.entity.Employe;
import com.cartaxaudit.gestionPaie.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeService {
    private EmployeRepository employeRepository;

    public void create(Employe employe) {
        employeRepository.save(employe);
    }

    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    public Employe get(int id) {
        Optional<Employe> employe = employeRepository.findById(id);
        return employe.orElseThrow(() -> new RuntimeException("Employé non trouvé avec l'ID : " + id));
    }
}

package com.cartaxaudit.gestionPaie.repository;

import com.cartaxaudit.gestionPaie.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
}

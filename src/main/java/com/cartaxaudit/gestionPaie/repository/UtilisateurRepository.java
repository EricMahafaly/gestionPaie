package com.cartaxaudit.gestionPaie.repository;


import com.cartaxaudit.gestionPaie.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);
}

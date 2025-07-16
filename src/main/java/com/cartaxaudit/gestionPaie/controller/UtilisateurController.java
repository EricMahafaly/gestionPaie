package com.cartaxaudit.gestionPaie.controller;

import com.cartaxaudit.gestionPaie.dto.AuthentificationDTO;
import com.cartaxaudit.gestionPaie.entity.Utilisateur;
import com.cartaxaudit.gestionPaie.service.JwtService;
import com.cartaxaudit.gestionPaie.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "utilisateur")
public class UtilisateurController {
    private AuthenticationManager authenticationManager;
    private UtilisateurService utilisateurService;
    private JwtService jwtService;

    @PostMapping(path = "inscription", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> inscription(@RequestBody Utilisateur utilisateur) {
        log.info("inscription");
        this.utilisateurService.inscription(utilisateur);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path = "connexion", consumes = APPLICATION_JSON_VALUE)
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.nomUtilisateur(), authentificationDTO.mdp())
        );
        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.nomUtilisateur());
        }
        return null;
    }


    @PutMapping(path = "deconnexion")
    public ResponseEntity<Void> deconnexion() {
        this.jwtService.deconnexion();
        log.info("deconnectee");

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package com.cartaxaudit.gestionPaie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmploye;

    private String nom;

    private String prenom;

    private String adresse;

    @Column(name = "numero_securite_sociale")
    private String numeroSecuriteSociale;

    private String email;

    private String telephone;

    private String poste;

    private String departement;

    @Column(name = "type_contrat")
    private String typeContrat;

    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;

    @Column(name = "salaire_brut_mensuel")
    private double salaireBrutMensuel;

    @Column(name = "taux_horaire")
    private double tauxHoraire;

    @Column(name = "conges_cumules_par_mois")
    private double congesCumulesParMois;

    @Column(name = "solde_conge")
    private double soldeConge;
}

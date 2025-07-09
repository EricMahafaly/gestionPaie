\c postgres;
DROP DATABASE gestion_paie;

CREATE DATABASE gestion_paie;
\c gestion_paie;


CREATE TABLE employe (
    id_employe SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    adresse VARCHAR(255),
    numero_securite_sociale VARCHAR(255),
    email VARCHAR(255),
    telephone VARCHAR(255),
    poste VARCHAR(255),
    departement VARCHAR(255),
    type_contrat VARCHAR(255),
    date_embauche DATE,
    salaire_brut_mensuel DOUBLE PRECISION,
    taux_horaire DOUBLE PRECISION,
    conges_cumules_par_mois DOUBLE PRECISION,
    solde_conge DOUBLE PRECISION
);
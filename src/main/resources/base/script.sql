\c postgres;
DROP DATABASE gestion_paie;

CREATE DATABASE gestion_paie;
\c gestion_paie;


create table utilisateur(
    id serial primary key,
    id_employe INTEGER,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    nom_utilisateur VARCHAR(255),
    mot_de_passe VARCHAR(255),--hashed
    actif BOOLEAN,
    role VARCHAR(255)-- admin, user, etc.
);

CREATE TABLE jwt (
    id SERIAL PRIMARY KEY,
    valeur VARCHAR(255),
    desactive BOOLEAN,
    expire BOOLEAN,
    id_utilisateur INTEGER,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id)
);

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

CREATE TABLE conge (
    id_conge SERIAL PRIMARY KEY,
    id_employe INTEGER,
    date_debut DATE,
    date_fin DATE,
    nombre_jours DOUBLE PRECISION,
    type VARCHAR(255),
    statut VARCHAR(255),
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

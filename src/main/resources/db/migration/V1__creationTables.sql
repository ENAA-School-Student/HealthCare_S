CREATE TABLE patient (
    id BIGINT auto_increment primary key,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    telephone VARCHAR(255),
    dateNaissance DATE
);


CREATE TABLE medecin(

    id  BIGINT auto_increment primary key,
    nom        VARCHAR(255),
    specialite VARCHAR(255),
    email      VARCHAR(255),
    telephone  VARCHAR(255)

);
CREATE TABLE dossier_medical(
                                id BIGINT auto_increment primary key,
                                diagnostic varchar(255),
                                observations varchar(255),
                                dateCreation Date,
                                medecin_id BIGINT,
                                patient_id  BIGINT

);



CREATE TABLE rendez_vous (
    id BIGINT auto_increment primary key,
    dateRendezVous DATE,
    statut VARCHAR(255),
    patient_id BIGINT,
    medecin_id  BIGINT
);












CREATE TABLE patient (
    id BIGINT auto_increment primary key not null,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    telephone VARCHAR(255),
    date_naissance DATE
);


CREATE TABLE medecin(

    id  BIGINT auto_increment primary key not null,
    nom        VARCHAR(255),
    specialite VARCHAR(255),
    email      VARCHAR(255),
    telephone  VARCHAR(255)

);
CREATE TABLE dossier_medical(
                                id BIGINT auto_increment primary key not null,
                                diagnostic varchar(255),
                                observations varchar(255),
                                date_creation Date,
                                medecin_id BIGINT,
                                patient_id  BIGINT

);



CREATE TABLE rendez_vous (
    id BIGINT auto_increment primary key,
    date_rendez_vous DATE,
    statut VARCHAR(255),
    patient_id BIGINT,
    medecin_id  BIGINT
);












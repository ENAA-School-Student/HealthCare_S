CREATE TABLE Patient (
    ID BIGINT auto_increment primary key,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    telephone VARCHAR(255),
    dateNaissance DATE


);


CREATE TABLE Medecin(

    ID         BIGINT auto_increment primary key,
    nom        VARCHAR(255),
    specialite VARCHAR(255),
    email      VARCHAR(255),
    telephone  VARCHAR(255)

);


CREATE TABLE RendezVous (
    ID BIGINT auto_increment primay key,
    dateRendezVous DATE,
    statut VARCHAR(255),
    patient_id BIGINT,
    medecin_id  BIGINT,
    foreign key (medecin_id) references Medecin(id),
    foreign key (patient_id  ) references Patient(id)

);


CREATE TABLE DossierMedical(
      ID BIGINT auto_increment primary key,
      diagnostic varchar(255),
      observations varchar(255),
      dateCreation Date,
      patient_id  BIGINT UNIQUE ,
      medecin_id BIGINT,
      foreign key (id) references Medecin(id),
      foreign key (patient_id) references Patient(id)








);










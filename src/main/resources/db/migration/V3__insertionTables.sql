INSERT INTO patient (nom, prenom, email, telephone, date_naissance)
VALUES
    ('Alaoui', 'Yassine', 'yassine.alaoui@gmail.com', '0612345678', '1998-05-12'),
    ('Bennani', 'Sara', 'sara.bennani@gmail.com', '0623456789', '2000-09-25'),
    ('El Idrissi', 'Hamza', 'hamza.elidrissi@gmail.com', '0634567891', '1995-03-18'),
    ('Amrani', 'Salma', 'salma.amrani@gmail.com', '0645678912', '1997-11-08'),
    ('Fassi', 'Omar', 'omar.fassi@gmail.com', '0656789123', '1994-07-21'),
    ('Chraibi', 'Imane', 'imane.chraibi@gmail.com', '0667891234', '2001-01-30'),
    ('Tahiri', 'Ayoub', 'ayoub.tahiri@gmail.com', '0678912345', '1999-12-14'),
    ('Mernissi', 'Lina', 'lina.mernissi@gmail.com', '0689123456', '2002-06-19'),
    ('Benjelloun', 'Adam', 'adam.benjelloun@gmail.com', '0691234567', '1996-04-10'),
    ('Kettani', 'Nadia', 'nadia.kettani@gmail.com', '0601122334', '1993-08-27');


INSERT INTO medecin (nom, specialite, email, telephone)
VALUES
    ('Karimi', 'Cardiologue', 'karimi@gmail.com', '0654321098'),
    ('Tazi', 'Dermatologue', 'tazi@gmail.com', '0665432109'),
    ('Lahlou', 'Pédiatre', 'lahlou@gmail.com', '0676543210'),
    ('Berrada', 'Neurologue', 'berrada@gmail.com', '0687654321'),
    ('Sefrioui', 'Généraliste', 'sefrioui@gmail.com', '0698765432'),
    ('Aouad', 'Ophtalmologue', 'aouad@gmail.com', '0609988776'),
    ('Cherkaoui', 'Radiologue', 'cherkaoui@gmail.com', '0612233445'),
    ('Majidi', 'Dentiste', 'majidi@gmail.com', '0623344556'),
    ('Naciri', 'Psychiatre', 'naciri@gmail.com', '0634455667'),
    ('Rami', 'ORL', 'rami@gmail.com', '0645566778');


INSERT INTO dossier_medical (diagnostic, observations, date_creation, medecin_id, patient_id)
VALUES
    ('Hypertension', 'Patient sous traitement', '2026-05-20', 1, 1),
    ('Allergie cutanée', 'Réaction légère observée', '2026-05-18', 2, 2),
    ('Fièvre', 'Repos recommandé', '2026-05-15', 3, 3),
    ('Migraine', 'Scanner demandé', '2026-05-12', 4, 4),
    ('Diabète', 'Contrôle glycémie régulier', '2026-05-10', 5, 5),
    ('Conjonctivite', 'Traitement de 7 jours', '2026-05-08', 6, 6),
    ('Asthme', 'Utilisation inhalateur', '2026-05-06', 7, 7),
    ('Fatigue chronique', 'Analyse sanguine demandée', '2026-05-04', 8, 8),
    ('Otite', 'Antibiotiques prescrits', '2026-05-02', 9, 9),
    ('Stress', 'Repos conseillé', '2026-05-01', 10, 10);


INSERT INTO rendez_vous (date_rendez_vous, statut, patient_id, medecin_id)
VALUES
    ('2026-06-01', 'CONFIRME', 1, 1),
    ('2026-06-03', 'EN_ATTENTE', 2, 2),
    ('2026-06-05', 'ANNULE', 3, 3),
    ('2026-06-07', 'CONFIRME', 4, 4),
    ('2026-06-09', 'TERMINE', 5, 5),
    ('2026-06-11', 'CONFIRME', 6, 6),
    ('2026-06-13', 'EN_ATTENTE', 7, 7),
    ('2026-06-15', 'ANNULE', 8, 8),
    ('2026-06-17', 'CONFIRME', 9, 9),
    ('2026-06-19', 'TERMINE', 10, 10);
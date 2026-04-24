package org.example.healthcare_s.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table( name="patient")
public class Patient {
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private LocalDate dateNaissance;
    @OneToMany
    private RendezVous rendezVous;
    @OneToOne
    private DossierMedical dossierMedical;
}

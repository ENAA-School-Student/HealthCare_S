package org.example.healthcare_s.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name="patient")
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private LocalDate dateNaissance;
    @OneToMany(mappedBy = "patient")
     private List<RendezVous> rendezVous;
    @OneToOne
    private DossierMedical dossierMedical;
}

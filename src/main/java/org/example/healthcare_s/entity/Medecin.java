package org.example.healthcare_s.entity;

import jakarta.persistence.*;

@Entity
@Table(name="medecin")
public class Medecin {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String specialite;
    private  String email;
    private String telephone;
    @OneToMany
    private RendezVous rendezVous;
    @OneToMany
    private DossierMedical dossierMedical;


}

package org.example.healthcare_s.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="dossierMedical")
public class DossierMedical {
    @Id
    @GeneratedValue
    private Long id;
    private String diagnostic;
    private String observations;
    private LocalDate dateCreation;
    @ManyToOne
    private Medecin medecin;


}

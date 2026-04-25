package org.example.healthcare_s.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="RendezVous")
public class RendezVous {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate dateRendezVous;
    private String statut;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="medecin_id")
    private Medecin medecin;

}

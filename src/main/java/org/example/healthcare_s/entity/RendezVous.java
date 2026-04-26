package org.example.healthcare_s.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="RendezVous")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateRendezVous;
    private String statut;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="medecin_id")
    private Medecin medecin;

}

package org.example.healthcare_s.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="dossierMedical")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DossierMedical {
    @Id
    @GeneratedValue
    private Long id;
    private String diagnostic;
    private String observations;
    private LocalDate dateCreation;
    @ManyToOne
    @JoinColumn(name="medecin_id")
    private Medecin medecin;
    @OneToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


}

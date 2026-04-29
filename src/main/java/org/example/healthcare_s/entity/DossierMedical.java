package org.example.healthcare_s.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="dossier_medical")
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    private String observations;
    @Column(name = "date_creation")
    private LocalDate dateCreation;
    @ManyToOne
    @JoinColumn(name="medecin_id" , unique = true)
    private Medecin medecin;
    @OneToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


}

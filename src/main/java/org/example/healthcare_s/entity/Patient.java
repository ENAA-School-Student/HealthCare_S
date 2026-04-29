package org.example.healthcare_s.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name="patient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
    @OneToMany(mappedBy = "patient")
     private List<RendezVous> rendezVous = new ArrayList<>();
    @OneToOne(mappedBy = "patient")
    private DossierMedical dossierMedical;
}

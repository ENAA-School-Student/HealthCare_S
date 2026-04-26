package org.example.healthcare_s.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="medecin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String specialite;
    private  String email;
    private String telephone;
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
    @OneToMany(mappedBy ="medecin")
    private List <DossierMedical> dossierMedical;


}

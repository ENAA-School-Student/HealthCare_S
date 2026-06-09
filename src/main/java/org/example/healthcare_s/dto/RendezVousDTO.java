package org.example.healthcare_s.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RendezVousDTO implements Serializable {
    private Long id;
    private LocalDate dateRendezVous;
    private String statut;
    private Long medecin_id;
    private Long patient_id;


}

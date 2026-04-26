package org.example.healthcare_s.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PatientDTO {
    private Long id;
    @NotBlank(message="ce champs est obligatoire")

    private String nom;
    @NotBlank(message="ce champs est obligatoire")
    private String prenom;
    private String telephone;
    private LocalDate dateNaissance;
}

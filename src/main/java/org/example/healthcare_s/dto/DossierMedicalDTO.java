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
public class DossierMedicalDTO {
    private Long id;
    @NotBlank(message="le champs est obligatoire")
    private String diagnostic;
    @NotBlank(message="le champs est obligatoire")
    private String observations;
    private LocalDate dateCreation;
}

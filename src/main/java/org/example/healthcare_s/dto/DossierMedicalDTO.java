package org.example.healthcare_s.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class DossierMedicalDTO {
    private Long id;


    @NotBlank(message="le champs est obligatoire")
    private String diagnostic;


    @NotBlank(message="le champs est obligatoire")
    private String observations;
    private LocalDate dateCreation;
    private long medecin_id;
    private long patient_id;
}

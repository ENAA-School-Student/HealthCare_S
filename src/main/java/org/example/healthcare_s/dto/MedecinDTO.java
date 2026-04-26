package org.example.healthcare_s.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedecinDTO {
    private Long id;
    @NotBlank(message="le champs est obliagtoire")
    private String nom;
    @NotBlank(message="le champs est obliagtoire")

    private String specialite;
    @Email(message="le format d'Email est invalide")
    private  String email;
    private String telephone;
}

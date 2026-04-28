package org.example.healthcare_s.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.service.DossierMedicalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dossierMedical")
public class DossierMedicalController {
    private final DossierMedicalService dossierMedicalService;
    @PostMapping
    public DossierMedicalDTO creerDossier(@RequestParam long medecin_id, @RequestParam long patient_id, @RequestBody DossierMedicalDTO dossierMedicalDTO){
        return dossierMedicalService.creeDossierMedical(medecin_id,patient_id,dossierMedicalDTO);
    }
    @GetMapping("/{id}")
    public DossierMedicalDTO consulterDossierMedical(@PathVariable long id,@RequestBody DossierMedicalDTO dossierMedicalDTO){
        return dossierMedicalService.consulterDossierMedical(id,dossierMedicalDTO);

    }

}

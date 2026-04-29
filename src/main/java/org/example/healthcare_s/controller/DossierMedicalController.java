package org.example.healthcare_s.controller;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.service.DossierMedicalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dossierMedical")
public class DossierMedicalController {
    private final DossierMedicalService dossierMedicalService;
    @PostMapping
    public ResponseEntity<?> creerDossier(@RequestParam long medecin_id, @RequestParam long patient_id, @RequestBody DossierMedicalDTO dossierMedicalDTO){
        DossierMedicalDTO dossierMedical=  dossierMedicalService.creeDossierMedical(medecin_id,patient_id,dossierMedicalDTO);
        if(dossierMedical == null){
            return ResponseEntity.badRequest().body("Ce patient a deja  un dossier medical");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dossierMedical);
    }
    @GetMapping("/{id}")
    public DossierMedicalDTO consulterDossierMedical(@PathVariable long id){
        return dossierMedicalService.consulterDossierMedical(id);
    }

    @PatchMapping("diagnostic/{id}")
    public ResponseEntity<DossierMedicalDTO>ajouterDiagnostic(@PathVariable long id,@RequestParam String diagnostic){
        return ResponseEntity.ok (dossierMedicalService.ajouterDiagnostic(id,diagnostic));

    }

    @PatchMapping("observation/{id}")
    public ResponseEntity<DossierMedicalDTO>ajouterObservations(@PathVariable long id,@RequestParam String observations){
        return ResponseEntity.ok (dossierMedicalService.ajouterObservations(id,observations));

    }


}

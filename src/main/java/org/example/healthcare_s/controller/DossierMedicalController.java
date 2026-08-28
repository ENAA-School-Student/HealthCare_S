package org.example.healthcare_s.controller;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.service.DossierMedicalService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/dossierMedical")
public class DossierMedicalController {
    private final DossierMedicalService dossierMedicalService;

    @PostMapping
    public ResponseEntity<?> creerDossier(@RequestParam long medecin_id, @RequestParam long patient_id, @RequestBody DossierMedicalDTO dossierMedicalDTO) {
        DossierMedicalDTO dossierMedical = dossierMedicalService.creeDossierMedical(medecin_id, patient_id, dossierMedicalDTO);
        if (dossierMedical == null) {
            return ResponseEntity.badRequest().body("Ce patient a deja  un dossier medical");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dossierMedical);
    }

    @GetMapping("/{id}")
    public DossierMedicalDTO consulterDossierMedical(@PathVariable long id) {
        return dossierMedicalService.consulterDossierMedical(id);
    }

    @PatchMapping("diagnostic/{id}")
    public ResponseEntity<DossierMedicalDTO> ajouterDiagnostic(@PathVariable long id, @RequestParam String diagnostic) {
        return ResponseEntity.ok(dossierMedicalService.ajouterDiagnostic(id, diagnostic));

    }

    @PatchMapping("observation/{id}")
    public ResponseEntity<DossierMedicalDTO> ajouterObservations(@PathVariable long id, @RequestParam String observations) {
        return ResponseEntity.ok(dossierMedicalService.ajouterObservations(id, observations));

    }


    @PostMapping("/dossierMedicalParPatient/{idPatient}")
    public ResponseEntity<DossierMedicalDTO> ajouterdossierMedicalParPatient(@PathVariable long idPatient,@RequestBody DossierMedicalDTO dossierMedicalDTO) {
        return ResponseEntity.ok(dossierMedicalService.ajouterdossierMedicalParPatient(idPatient,dossierMedicalDTO));

    }

    @GetMapping
    public Page<DossierMedicalDTO> listerDossiers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return dossierMedicalService.listerDossiers(page, size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DossierMedicalDTO> modifierDossierMedical(
            @PathVariable long id,
            @RequestParam long medecin_id,
            @RequestParam long patient_id,
            @RequestBody DossierMedicalDTO dossierMedicalDTO) {
        return ResponseEntity.ok(dossierMedicalService.modifierDossierMedical(id, medecin_id, patient_id, dossierMedicalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDossierMedical(@PathVariable long id) {
        dossierMedicalService.supprimerDossierMedical(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dossierMedicalParPatient/{idPatient}")
    public ResponseEntity dossierMedicalParPatient(@PathVariable long idPatient) {
        return ResponseEntity.ok(dossierMedicalService.dossierMedicalParPatient(idPatient));

    }


}

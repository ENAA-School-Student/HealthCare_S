package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.service.MedecinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecins")
@RequiredArgsConstructor
public class MedecinController {
    private final MedecinService medecinService;

    @PostMapping
    public ResponseEntity<MedecinDTO> ajouterMedecin(@Valid @RequestBody MedecinDTO medecinDTO){
        return ResponseEntity.ok(medecinService.ajouterMedecin(medecinDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MedecinDTO>modifiermMedecin( @Valid @PathVariable long id,@RequestBody MedecinDTO medecinDTO){
        return ResponseEntity.ok(medecinService.modifierMedecin(id,medecinDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void>supprimerMedecin(@PathVariable long id){
         medecinService.supprimerMedecin(id);
         return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<MedecinDTO>listerMedecins(){
        return medecinService.listerMedecins();
    }



}

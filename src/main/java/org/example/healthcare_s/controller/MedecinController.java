package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.service.MedecinService;
import org.example.healthcare_s.service.RendezVousService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/medecins")
@RequiredArgsConstructor
public class MedecinController {
    private final MedecinService medecinService;
    private final RendezVousService rendezVousService;

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

    @GetMapping("/medecinsSpecialite")
    public ResponseEntity <Page<MedecinDTO>>findAllBySpecialite(
            @RequestParam(value="page",defaultValue = "0")int page,
            @RequestParam(value="size",defaultValue = "20")int size,
            @RequestParam String specialite
    ){
        Page<MedecinDTO>medecins=medecinService.findAllBySpecialite(page,size,specialite);
        return ResponseEntity.ok(medecins);

    }





}

package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.RendezVous;
import org.example.healthcare_s.service.RendezVousService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rendezvous")
public class   RendezVousController {
    private final RendezVousService rendezVousService;
    @PostMapping
    public RendezVousDTO creeRendezVous(@RequestParam long medecin_id,long patient_id,@Valid @RequestBody RendezVousDTO rendezVousDTO){
        return rendezVousService.creerRendezVous(medecin_id,patient_id,rendezVousDTO);

    }

    @PutMapping
    public ResponseEntity<RendezVousDTO>modifierRendezVous(@PathVariable long id,@RequestBody RendezVousDTO rendezVousDTO){
        return ResponseEntity.ok(rendezVousService.modifierRendezVous(id,rendezVousDTO));
    }
    @GetMapping
    public List<RendezVousDTO> listerRendezVous(){
        return rendezVousService.listerRendezVous();

    }// a completer
    @GetMapping("/annulerRendezVous/{id}")
    public RendezVousDTO annulerRendezVous(long id,RendezVousDTO rendezVousDTO){
         return rendezVousService.annulerRendezVous(id,rendezVousDTO);
    }



}

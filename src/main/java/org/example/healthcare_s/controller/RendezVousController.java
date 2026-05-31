package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.service.RendezVousService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PutMapping("/{id}")
    public ResponseEntity<RendezVousDTO>modifierRendezVous(
            @PathVariable long id ,@RequestBody RendezVousDTO rendezVousDTO ,
            @RequestParam  long medecin_id ,@RequestParam long patient_id
            ){
        return ResponseEntity.ok(rendezVousService.modifierRendezVous(id,rendezVousDTO,medecin_id,patient_id));
    }
    @GetMapping
    public List<RendezVousDTO> listerRendezVous(){
        return rendezVousService.listerRendezVous();

    }

    @PutMapping("/annulerRendezVous/{id}")
    public RendezVousDTO annulerRendezVous(@PathVariable long id,@RequestBody RendezVousDTO rendezVousDTO){
         return rendezVousService.annulerRendezVous(id,rendezVousDTO);
    }
    @GetMapping("/chercherParPatient/{id}")
    public List<RendezVousDTO>chercherparPatient(@PathVariable long id){
        return rendezVousService.rechercherRendezVousParPatient(id);
    }

    @GetMapping("/rechercherparMedecin/{id}")
    public List<RendezVousDTO>rechercherRendezVousparMedecin(@PathVariable long id){
        return rendezVousService.rechercherRendezVousParMedecin(id);
    }

    @GetMapping("/rendezvousDate")
    ResponseEntity<Page<RendezVousDTO>> findAllPatientByNom(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam LocalDate date
    ) {

        Page<RendezVousDTO> rendezvous = rendezVousService.findAllOrderByDate(date, page, size);
        return ResponseEntity.ok(rendezvous);
    }
    @GetMapping("/rendezvousStatut")
    ResponseEntity<Page<RendezVousDTO>> findAllPatientByNom(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam String statut
    ) {

        Page<RendezVousDTO> rendezvous = rendezVousService.findRendezVousByStatut(statut, page, size);
        return ResponseEntity.ok(rendezvous);
    }





}

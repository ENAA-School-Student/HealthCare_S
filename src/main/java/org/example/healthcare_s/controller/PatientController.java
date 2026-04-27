package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final  PatientService patientService;
    @PostMapping
    public ResponseEntity<PatientDTO>ajouterPatient(@Valid @RequestBody PatientDTO patientDTO){
        return ResponseEntity.ok(patientService.ajouterPatient(patientDTO));

    }
    @GetMapping
    public List<PatientDTO>listerPatients(){
        return patientService.listerPatients();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO>modifierPatient(@PathVariable long id,@Valid @RequestBody PatientDTO patientDTO){
        return ResponseEntity.ok(patientService.modifierPatient(id,patientDTO));

    }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerPatient(@PathVariable long id){
        patientService.supprimerPatient(id);
        return ResponseEntity.ok().build();
   }
   @GetMapping("/{id}")
    public ResponseEntity<PatientDTO>consulterPatient(@PathVariable long id){
        return ResponseEntity.ok(patientService.consulterPatient(id));
   }


}

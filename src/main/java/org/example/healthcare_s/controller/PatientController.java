package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.repository.PatientRepository;
import org.example.healthcare_s.service.PatientService;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final  PatientService patientService;
    private final PatientRepository patientRepository;
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

    @GetMapping("/PatientsNom")
    ResponseEntity<Page<PatientDTO>> findAllPatientByNom(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size
    ) {

        Page<PatientDTO> patients = patientService.findAllByOrderByNomDesc(size,page);
        return ResponseEntity.ok(patients);
    }


}

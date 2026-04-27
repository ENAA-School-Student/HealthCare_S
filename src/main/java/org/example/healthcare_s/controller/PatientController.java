package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
    private PatientService patientService;
    @PostMapping
    public ResponseEntity<PatientDTO>ajouterPatient(@Valid @RequestBody PatientDTO patientDTO){
        return ResponseEntity.ok(patientService.ajouterPatient(patientDTO));

    }

}

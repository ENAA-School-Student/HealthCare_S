package org.example.healthcare_s.unit_testing;

import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.service.PatientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Test
    @DisplayName("test d'ajout d'un patient")
    void ajouterPatient() {

        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setNom("Imane");

        PatientDTO patientDTO1= patientService.ajouterPatient(patientDTO);
        assertNotNull(patientDTO1);

        assertEquals("Imane",patientDTO1.getNom());

    }



}

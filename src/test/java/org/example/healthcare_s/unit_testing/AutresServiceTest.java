package org.example.healthcare_s.unit_testing;

import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.repository.MedecinRepository;
import org.example.healthcare_s.service.DossierMedicalService;
import org.example.healthcare_s.service.MedecinService;
import org.example.healthcare_s.service.PatientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AutresServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
     private MedecinService medecinService;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private DossierMedicalService dossierMedicalService;


    @Test
    @DisplayName("test d'ajout d'un patient")
    void ajouterPatient() {

        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setNom("Imane");

        PatientDTO patientDTO1= patientService.ajouterPatient(patientDTO);
        assertNotNull(patientDTO1);

        assertEquals("Imane",patientDTO1.getNom());

    }



    @Test
    @DisplayName("tester suppression d'un medecin")
    void supprimerMedecin(){
        long medecin_id = 1L;

       medecinService.supprimerMedecin(medecin_id);
       assertFalse(medecinRepository.existsById(medecin_id));


    }


    @Test
    @DisplayName("test de Consultation d'un dossier médical")
    void consulterDossierMedicale(){
        long medecin_id= 2L;
        long patient_id=11L;
        DossierMedicalDTO dossierMedicalDTO = new DossierMedicalDTO();
        dossierMedicalDTO.setObservations("tres malade");

        DossierMedicalDTO dossierMedicalDTO1= dossierMedicalService.creeDossierMedical(medecin_id,patient_id,dossierMedicalDTO);
        assertNotNull(dossierMedicalDTO1);
        assertEquals("tres malade",dossierMedicalDTO1.getObservations());

    }




}

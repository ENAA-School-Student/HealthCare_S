package org.example.healthcare_s.unit_testing;

import jakarta.transaction.Transactional;

import org.example.healthcare_s.dto.RendezVousDTO;

import org.example.healthcare_s.service.RendezVousService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class RendezVousServiceTest {

    @Autowired
    private RendezVousService rendezVousService;

    @Test
    @DisplayName("test de création de  rendezVous")
    void creeRendezVous(){
        long medecin_id = 1L;
        long patient_id=1L;

        RendezVousDTO rendezVousDTO = new RendezVousDTO();
        rendezVousDTO.setStatut("en_attente");
        RendezVousDTO rendez= rendezVousService.creerRendezVous(medecin_id,patient_id,rendezVousDTO);
        assertNotNull(rendez);
        assertEquals(patient_id,rendez.getPatient_id());
    }

    @Test
    @DisplayName("test de modification de rendezVous")
    void modifierRendezVous(){
        long medecin_id = 1L;
        long patient_id=1L;
        long rendezVous_id=2L;
        RendezVousDTO rendezVousDTO= new RendezVousDTO(
                2L,
                LocalDate.parse("2026-04-30"),
                "annule",
                 1L,
                 1L


        );
        RendezVousDTO rendezVous=rendezVousService.modifierRendezVous(
                rendezVous_id,
                rendezVousDTO,
                medecin_id,
                patient_id


        );
        assertNotNull(rendezVous);
        assertEquals("annule",rendezVous.getStatut());
        assertEquals(LocalDate.parse("2026-04-30"),rendezVous.getDateRendezVous());

    }


    @Test
    @DisplayName("annuler un rendevous")
            void annulerRendezVous(){
        long rendezvous_id=2L;
        RendezVousDTO rendezVousDTO= new RendezVousDTO();
        rendezVousDTO.setStatut("annule");


        RendezVousDTO rendezVousDTO1=rendezVousService.annulerRendezVous(rendezvous_id,rendezVousDTO);
        assertNotNull(rendezVousDTO1);
        assertEquals("annule",rendezVousDTO.getStatut());
    }



    @Test
    @DisplayName("test lister les rendezvous")
    void listerRendezVous(){

        //j'ai pas utilisé arrange parce que j'ai deja liste de rendezVous
        List<RendezVousDTO> rendezVous= rendezVousService.listerRendezVous();
        assertNotNull(rendezVous);
        assertEquals(1,rendezVous.size());




    }
    @Test
    @DisplayName(" Rechercher rendez vous par patient")
    void rendezVousPatient(){
        long patient_id = 1L;
        List<RendezVousDTO> rendezVousDTOList=rendezVousService.rechercherRendezVousParPatient(patient_id);
        assertNotNull(rendezVousDTOList);
        assertFalse(rendezVousDTOList.isEmpty());
        assertEquals(1L,rendezVousDTOList.get(0).getPatient_id());




    }






}

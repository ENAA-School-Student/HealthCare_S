package org.example.healthcare_s.unit_testing;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.DossierMedical;
import org.example.healthcare_s.service.RendezVousService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@RequiredArgsConstructor
@SpringBootTest
public class RendezVousTest {

    private RendezVousService rendezVousService;

    void creeRendezVous(){
        long medecin_id = 1L;
        long patient_id=1L;

        RendezVousDTO rendezVousDTO = new RendezVousDTO();
        rendezVousDTO.setStatut("en_attente");

        RendezVousDTO rendez= rendezVousService.creerRendezVous(medecin_id,patient_id,rendezVousDTO);
        assertNotNull(rendez);












    }
}

package org.example.healthcare_s.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.DossierMedical;
import org.example.healthcare_s.entity.Medecin;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.entity.RendezVous;
import org.example.healthcare_s.mapper.DossierMedicalMapper;
import org.example.healthcare_s.mapper.RendezVousMapper;
import org.example.healthcare_s.repository.DossierMedicalRepository;
import org.example.healthcare_s.repository.MedecinRepository;
import org.example.healthcare_s.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DossierMedicalService {
    private final DossierMedicalRepository dossierMedicalRepository;
    private final DossierMedicalMapper dossierMedicalMapper;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;
    private final RendezVousMapper rendezVousMapper;


    @Transactional
    public DossierMedicalDTO creeDossierMedical(long medecin_id, long patient_id, DossierMedicalDTO dossierMedicalDTO){
        if(dossierMedicalRepository.existsByPatientId(patient_id))
        {
            return null;
        }
        DossierMedical dossierMedical= dossierMedicalMapper.toEntity(dossierMedicalDTO);
        Medecin medecin=medecinRepository.findById(medecin_id).get();
        Patient patient=patientRepository.findById(patient_id).get();
        dossierMedical.setMedecin(medecin);
        dossierMedical.setPatient(patient);
        dossierMedical.setDateCreation(LocalDate.now());
        DossierMedical dossierMedicalSaved=dossierMedicalRepository.save(dossierMedical);
        return dossierMedicalMapper.toDTO(dossierMedicalSaved);

    }

    public DossierMedicalDTO consulterDossierMedical(long id){
        DossierMedical dossierMedical=dossierMedicalRepository.findById(id).orElseThrow();
        return dossierMedicalMapper.toDTO(dossierMedical);
    }

    public DossierMedicalDTO ajouterDiagnostic(long id,String diagnostic){

        DossierMedical dossierMedical= dossierMedicalRepository.findById(id).orElse(null);
        if(dossierMedical==null){
            throw new RuntimeException("Erreur");

        }
        dossierMedical.setDiagnostic(diagnostic);
        DossierMedical dossierMedicalsaved=dossierMedicalRepository.save(dossierMedical);
        return dossierMedicalMapper.toDTO(dossierMedicalsaved);

    }


    public DossierMedicalDTO ajouterObservations(long id,String observations){
        DossierMedical dossierMedical=dossierMedicalRepository.findById(id).orElse(null);
        if(dossierMedical == null){
            throw new RuntimeException("Erreur");
        }
        dossierMedical.setObservations(observations);
        DossierMedical dossierMedical1=dossierMedicalRepository.save(dossierMedical);
        return dossierMedicalMapper.toDTO(dossierMedical1);
    }


}

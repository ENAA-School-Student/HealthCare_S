package org.example.healthcare_s.service;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.Medecin;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.entity.RendezVous;
import org.example.healthcare_s.mapper.RendezVousMapper;
import org.example.healthcare_s.repository.MedecinRepository;
import org.example.healthcare_s.repository.PatientRepository;
import org.example.healthcare_s.repository.RendezVousRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousService {
    private final RendezVousMapper rendezVousMapper;
    private final RendezVousRepository rendezVousRepository;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;

@CacheEvict(value = "rendezvous",allEntries = true)
    public RendezVousDTO creerRendezVous(long medecin_id, long patient_id, RendezVousDTO rendezVousDTO) {
        RendezVous rendezVous = rendezVousMapper.toEntity(rendezVousDTO);
        Medecin medecin = medecinRepository.findById(medecin_id).orElseThrow();
        Patient patient = patientRepository.findById(patient_id).orElseThrow();
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);

        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return rendezVousMapper.toDTO(savedRendezVous);

    }
    @CacheEvict(value = "rendezvous",allEntries = true)
    public RendezVousDTO modifierRendezVous(
            long id, RendezVousDTO rendezVousDTO,
            long medecin_id, long patient_id) {
        if (!rendezVousRepository.existsById(id)) {
            throw new RuntimeException("l'entite n'existe pas");
        }
        RendezVous rendezVous = rendezVousMapper.toEntity(rendezVousDTO);
        rendezVous.setId(id);
        Medecin medecin = medecinRepository.findById(medecin_id).orElseThrow();
        Patient patient = patientRepository.findById(patient_id).orElseThrow();
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);
        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return rendezVousMapper.toDTO(savedRendezVous);
    }
    @Cacheable(value="rendezvous",key="'all'")

    public List<RendezVousDTO> listerRendezVous() {
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        return rendezVousMapper.toDTOList(rendezVousList);


    }
    @CacheEvict(value="rendezvous",key="#id")
    public RendezVousDTO annulerRendezVous(long id, RendezVousDTO rendezVousDTO) {
        if (rendezVousRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Erreur");
        }
        int rendezVousannule = rendezVousRepository.modifierStatutRendezVous(id);

        RendezVous rendezVousreturne = rendezVousRepository.findById(id).get();
        return rendezVousMapper.toDTO(rendezVousreturne);

    }
    @Cacheable(value = "rendezvous",key="#id")

    public List<RendezVousDTO> rechercherRendezVousParPatient(long id) {
        List<RendezVous> rendezVousList = rendezVousRepository.rechercherRendezVousParPatient(id);
        return rendezVousList.stream().map(rendezVousMapper::toDTO).toList();

    }
    @Cacheable(value = "rendezvous",key="#id")
    public List<RendezVousDTO> rechercherRendezVousParMedecin(long id) {
        List<RendezVous> rendezVousList = rendezVousRepository.rechercherRendezVousParmedecin(id);
        return rendezVousList.stream().map(rendezVousMapper::toDTO).toList();
    }


}

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousService {
    private final RendezVousMapper rendezVousMapper;
    private final RendezVousRepository rendezVousRepository;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;


    public RendezVousDTO creerRendezVous(long medecin_id, long patient_id, RendezVousDTO rendezVousDTO) {
        RendezVous rendezVous = rendezVousMapper.toEntity(rendezVousDTO);
        Medecin medecin = medecinRepository.findById(medecin_id).orElseThrow();
        Patient patient = patientRepository.findById(patient_id).orElseThrow();
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);

        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return rendezVousMapper.toDTO(savedRendezVous);

    }

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

    public List<RendezVousDTO> listerRendezVous() {
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        return rendezVousMapper.toDTOList(rendezVousList);


    }

    public RendezVousDTO annulerRendezVous(long id, RendezVousDTO rendezVousDTO) {
        if (rendezVousRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Erreur");
        }
        int rendezVousannule = rendezVousRepository.modifierStatutRendezVous(id);

        RendezVous rendezVousreturne = rendezVousRepository.findById(id).get();
        return rendezVousMapper.toDTO(rendezVousreturne);

    }

    public List<RendezVousDTO> rechercherRendezVousParPatient(long id) {
        List<RendezVous> rendezVousList = rendezVousRepository.rechercherRendezVousParPatient(id);
        return rendezVousList.stream().map(rendezVousMapper::toDTO).toList();

    }

    public List<RendezVousDTO> rechercherRendezVousParMedecin(long id) {
        List<RendezVous> rendezVousList = rendezVousRepository.rechercherRendezVousParmedecin(id);
        return rendezVousList.stream().map(rendezVousMapper::toDTO).toList();
    }

    public Page<RendezVousDTO>findAllOrderByDate(LocalDate date ,int page, int size){
        Pageable pageable= PageRequest.of(page, size);
        Page<RendezVous> rendezVous=rendezVousRepository.findAllOrderByDateRendezVous(date,pageable);
        return rendezVous.map(rendezVousMapper::toDTO);

    }
    public Page<RendezVousDTO>findRendezVousByStatut(String statut,int page ,int size){
        Pageable pageable= PageRequest.of(page, size);
        Page<RendezVous>rendezVous=rendezVousRepository.findAllByStatut(statut,pageable);
        return rendezVous.map(rendezVousMapper::toDTO);


    }


}

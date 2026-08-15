package org.example.healthcare_s.service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import jakarta.persistence.EntityNotFoundException;

import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.mapper.PatientMapper;
import org.example.healthcare_s.repository.DossierMedicalRepository;
import org.example.healthcare_s.repository.PatientRepository;
import org.example.healthcare_s.repository.RendezVousRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private  final PatientMapper patientMapper;
    private final RendezVousRepository rendezVousRepository;
    private final DossierMedicalRepository dossierMedicalRepository;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, RendezVousRepository rendezVousRepository, DossierMedicalRepository dossierMedicalRepository) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.rendezVousRepository = rendezVousRepository;
        this.dossierMedicalRepository = dossierMedicalRepository;
    }

//@CacheEvict(value="patients",allEntries = true)
    public PatientDTO ajouterPatient(PatientDTO patientDTO){
        Patient patient=patientMapper.toEntity(patientDTO);
        Patient savedPatient=patientRepository.save(patient);
        return patientMapper.toDTO(savedPatient);

    }
//    @CacheEvict(value="patients",allEntries = true)

    public PatientDTO modifierPatient(long id,PatientDTO patientDTO){
        if (!patientRepository.existsById(id)){
            throw new EntityNotFoundException("Erreur ");
        }
        Patient patient = patientMapper.toEntity(patientDTO);
        patient.setId(id);
        Patient patientUpdated=patientRepository.save(patient);
        return patientMapper.toDTO(patientUpdated);

    }
//   @Cacheable(value="patients",key="'all'")
//    @Cacheable(value="patients")
    public List<PatientDTO>listerPatients(){
        System.out.println("=========================================test Redis================");
        List<Patient> clients=patientRepository.findAll();
        return patientMapper.toDTOList(clients);
    }

    public Page<PatientDTO> listerPatients(int page, int size){
        return patientRepository.findAll(PageRequest.of(page, size)).map(patientMapper::toDTO);
    }
    @CacheEvict(value="patients",allEntries = true)
    @Transactional
    public void  supprimerPatient(Long id){
        if(!patientRepository.existsById(id)){
            throw new RuntimeException("Erreur");
        }
        rendezVousRepository.deleteByPatientId(id);
        dossierMedicalRepository.deleteByPatientId(id);
        patientRepository.deleteById(id);
    }
    @Cacheable(value="patients",key="#id")
    public PatientDTO consulterPatient(long id){
        Patient patient=patientRepository.findById(id).orElseThrow();
        return patientMapper.toDTO(patient);
    }

    public PatientDTO filtrerParNomEtPrenom(String nom){
        Patient patient=patientRepository.findPatientByNomOrPrenom(nom);
        return patientMapper.toDTO(patient);

    }

}

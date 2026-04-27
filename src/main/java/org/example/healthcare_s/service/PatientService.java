package org.example.healthcare_s.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.mapper.PatientMapper;
import org.example.healthcare_s.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private  final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    public PatientDTO ajouterPatient(PatientDTO patientDTO){
        Patient patient=patientMapper.toEntity(patientDTO);
        Patient savedPatient=patientRepository.save(patient);
        return patientMapper.toDTO(savedPatient);

    }
    public PatientDTO modifierPatient(long id,PatientDTO patientDTO){
        if (!patientRepository.existsById(id)){
            throw new EntityNotFoundException("Erreur ");
        }
        Patient patient = patientMapper.toEntity(patientDTO);
        patient.setId(id);
        Patient patientUpdated=patientRepository.save(patient);
        return patientMapper.toDTO(patientUpdated);

    }
    public List<PatientDTO>listerPatients(){
        List<Patient> clients=patientRepository.findAll();
        return patientMapper.toDTOList(clients);
    }
    public void  SupprimerPatient(Long id){
        if(!patientRepository.existsById(id)){
            throw new RuntimeException("Erreur");
        }

        patientRepository.deleteById(id);
    }

}

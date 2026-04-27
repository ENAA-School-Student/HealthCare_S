package org.example.healthcare_s.service;

import lombok.AllArgsConstructor;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.mapper.PatientMapper;
import org.example.healthcare_s.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service()
public class PatientService {
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;


//    public PatientDTO ajouterPatient(PatientDTO patientDTO){
//        Patient patient=patientMapper.toEntity(patientDTO);
//        Patient savedPatient=patientRepository.save(patient);
//        return patientMapper.toDTO(savedPatient);
//
//
//    }
}

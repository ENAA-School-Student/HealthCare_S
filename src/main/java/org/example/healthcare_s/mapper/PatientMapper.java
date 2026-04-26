package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PatientMapper {
    PatientDTO toDTO(Patient patient);
    Patient toEntity( PatientDTO patientDTO);
    List<PatientDTO>toDTOList(List<Patient> patientList);

}

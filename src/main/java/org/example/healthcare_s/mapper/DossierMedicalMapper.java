package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.entity.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DossierMedicalMapper {
    @Mapping(target="medecin_id",source="medecin.id")
    @Mapping(target="patient_id",source="patient.id")
    DossierMedicalDTO toDTO(DossierMedical dossierMedical);
    @Mapping(target="medecin",ignore = true)
    @Mapping(target="patient",ignore=true)
    DossierMedical toEntity(DossierMedicalDTO dossierMedicalDTO);
    List<DossierMedicalDTO> toDTOList(List<DossierMedical>dossierMedicalList);

}

package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.DossierMedicalDTO;
import org.example.healthcare_s.entity.DossierMedical;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DossierMedicalMapper {
    DossierMedicalDTO toDTO(DossierMedical dossierMedical);
    DossierMedical toEntity(DossierMedicalDTO dossierMedicalDTO);
    List<DossierMedicalDTO> toDTOList(List<DossierMedical>dossierMedicalList);

}

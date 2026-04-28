package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.RendezVous;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RendezVousMapper {
//    @Mapping(target = "id",ignore = true)
   @Mapping(target = "medecin_id",source = "medecin.id")
   @Mapping(target = "patient_id",source = "patient.id")
    RendezVousDTO toDTO(RendezVous rendezVous);
     RendezVous toEntity(RendezVousDTO rendezVousDTO);
    List<RendezVousDTO> toDTOList(List<RendezVous> rendezVousList);
}

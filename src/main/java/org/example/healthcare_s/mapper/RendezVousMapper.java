package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.RendezVous;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RendezVousMapper {
    RendezVousDTO toDTO(RendezVous rendezVous);
     RendezVous toEntity(RendezVous rendezVous);
    List<RendezVousDTO> toDTOList(List<RendezVous> rendezVousList);
}

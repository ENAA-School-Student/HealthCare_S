package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.entity.Medecin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface MedecinMapper {
    MedecinDTO toDTO(Medecin medecin);
    Medecin toEntity(MedecinDTO medecinDTO);
    List<MedecinDTO>toDTOList(List<Medecin> medecinList);
}

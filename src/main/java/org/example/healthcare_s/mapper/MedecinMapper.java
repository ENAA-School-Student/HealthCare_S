package org.example.healthcare_s.mapper;

import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.entity.Medecin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface MedecinMapper {
    @Mapping(target = "id",ignore = true)
    MedecinDTO toDTO(Medecin medecin);
    Medecin toEntity(MedecinDTO medecinDTO);
    List<MedecinDTO>toDTOList(List<Medecin> medecinList);
}

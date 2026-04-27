package org.example.healthcare_s.service;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.RendezVous;
import org.example.healthcare_s.mapper.RendezVousMapper;
import org.example.healthcare_s.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RendezVousService {
    private final RendezVousService rendezVousService;
    private final RendezVousMapper rendezVousMapper;
    private final RendezVousRepository rendezVousRepository;


    public RendezVousDTO creerRendezVous(RendezVousDTO rendezVousDTO){
        RendezVous rendezVous=rendezVousMapper.toEntity(rendezVousDTO);
        RendezVous savedRendezVous=rendezVousRepository.save(rendezVous);
        return rendezVousMapper.toDTO(savedRendezVous);

    }
}

package org.example.healthcare_s.service;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.RendezVousDTO;
import org.example.healthcare_s.entity.RendezVous;
import org.example.healthcare_s.mapper.RendezVousMapper;
import org.example.healthcare_s.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public RendezVousDTO modifierRendezVous(long id,RendezVousDTO rendezVousDTO){
        if(!rendezVousRepository.existsById(id)){
            throw new RuntimeException("l'entite n'existe pas");
        }
        RendezVous rendezVous=rendezVousMapper.toEntity(rendezVousDTO);
        rendezVous.setId(id);
        RendezVous savedRendezVous=rendezVousRepository.save(rendezVous);
        return rendezVousMapper.toDTO(savedRendezVous);
    }

    public List<RendezVousDTO>listerRendezVous( ){
        List<RendezVous>rendezVousList=rendezVousRepository.findAll();
        return rendezVousMapper.toDTOList(rendezVousList);



    }


    public RendezVousDTO annulerRendezVous(long id,RendezVousDTO rendezVousDTO){
        int rendezVousannule=rendezVousRepository.modifierStatutRendezVous(id);
        if(rendezVousRepository.findById(id).isEmpty()){
            throw new RuntimeException ("Erreur");
        }
        Optional<RendezVous> rendezVousreturne=rendezVousRepository.findById(id);
         RendezVous rendezVous=rendezVousreturne.get();
        return rendezVousMapper.toDTO(rendezVous);




    }



}

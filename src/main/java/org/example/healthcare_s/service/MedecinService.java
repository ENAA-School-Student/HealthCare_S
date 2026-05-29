package org.example.healthcare_s.service;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.entity.Medecin;
import org.example.healthcare_s.mapper.MedecinMapper;
import org.example.healthcare_s.repository.MedecinRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedecinService {
    private final MedecinRepository medecinRepository;
    private final MedecinMapper medecinMapper;


    public MedecinDTO ajouterMedecin(MedecinDTO medecinDTO){
        Medecin medecin=medecinMapper.toEntity(medecinDTO);
        Medecin savedMedecin=medecinRepository.save(medecin);
        return medecinMapper.toDTO(savedMedecin);

    }

    public MedecinDTO modifierMedecin(long id ,MedecinDTO medecinDTO){
        if(!medecinRepository.existsById(id)){
            throw new RuntimeException("Erreur");
        }
        Medecin medecin=medecinMapper.toEntity(medecinDTO);
        medecin.setId(id);
        Medecin savedMedecin=medecinRepository.save(medecin);
        return medecinMapper.toDTO(savedMedecin);

    }

    public void supprimerMedecin(long id){
        if(!medecinRepository.existsById(id)){
            throw new RuntimeException("Erreur");
        }
        medecinRepository.deleteById(id);

    }

    public List<MedecinDTO>listerMedecins(){
        List<Medecin>medecinList=medecinRepository.findAll();
        return medecinMapper.toDTOList(medecinList);
    }
    public Page<MedecinDTO> findAllBySpecialite(int page ,int size,  String specialite){
        Pageable pageable = PageRequest.of(page, size);
        Page<Medecin>medecins=medecinRepository.findAllBySpecialite(specialite,pageable);
        return medecins.map(medecinMapper::toDTO);

    }
}

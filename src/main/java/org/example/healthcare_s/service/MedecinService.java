package org.example.healthcare_s.service;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.entity.Medecin;
import org.example.healthcare_s.mapper.MedecinMapper;
import org.example.healthcare_s.repository.MedecinRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedecinService {
    private final MedecinRepository medecinRepository;
    private final MedecinMapper medecinMapper;

    @CacheEvict(value="medecins",allEntries = true)

    public MedecinDTO ajouterMedecin(MedecinDTO medecinDTO){
        Medecin medecin=medecinMapper.toEntity(medecinDTO);
        Medecin savedMedecin=medecinRepository.save(medecin);
        return medecinMapper.toDTO(savedMedecin);

    }
    @CacheEvict(value="medecins",allEntries = true)

    public MedecinDTO modifierMedecin(long id ,MedecinDTO medecinDTO){
        if(!medecinRepository.existsById(id)){
            throw new RuntimeException("Erreur");
        }
        Medecin medecin=medecinMapper.toEntity(medecinDTO);
        medecin.setId(id);
        Medecin savedMedecin=medecinRepository.save(medecin);
        return medecinMapper.toDTO(savedMedecin);

    }
    @CacheEvict(value="medecins",allEntries = true)

    public void supprimerMedecin(long id){
        if(!medecinRepository.existsById(id)){
            throw new RuntimeException("Erreur");
        }
        medecinRepository.deleteById(id);

    }
    @Cacheable(value="medecins",key="'all'")
    public List<MedecinDTO>listerMedecins(){
        System.out.println("==============lister medecins======================");
        List<Medecin>medecinList=medecinRepository.findAll();
        return medecinMapper.toDTOList(medecinList);
    }
}

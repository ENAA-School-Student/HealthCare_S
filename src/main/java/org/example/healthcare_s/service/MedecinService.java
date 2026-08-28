package org.example.healthcare_s.service;

import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.MedecinDTO;
import org.example.healthcare_s.entity.Medecin;
import org.example.healthcare_s.entity.User;
import org.example.healthcare_s.enums.Role;
import org.example.healthcare_s.mapper.MedecinMapper;
import org.example.healthcare_s.repository.MedecinRepository;
import org.example.healthcare_s.repository.security.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedecinService {
    private final MedecinRepository medecinRepository;
    private final MedecinMapper medecinMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @CacheEvict(value="medecins",allEntries = true)

    public MedecinDTO ajouterMedecin(MedecinDTO medecinDTO){
        Medecin medecin=medecinMapper.toEntity(medecinDTO);
        Medecin savedMedecin=medecinRepository.save(medecin);

        // Create User account for the doctor
        if (medecinDTO.getPassword() != null && !medecinDTO.getPassword().isBlank()) {
            User user = new User();
            user.setUsername(medecinDTO.getNom());
            user.setEmail(medecinDTO.getEmail());
            user.setRole(Role.ROLE_DOCTOR);
            user.setPassword(passwordEncoder.encode(medecinDTO.getPassword()));
            userRepository.save(user);
        }

        return medecinMapper.toDTO(savedMedecin);

    }
    @CacheEvict(value="medecins",allEntries = true)

    public MedecinDTO modifierMedecin(long id ,MedecinDTO medecinDTO){
        Medecin oldMedecin = medecinRepository.findById(id).orElseThrow(() -> new RuntimeException("Erreur"));
        String oldEmail = oldMedecin.getEmail();

        Medecin medecin=medecinMapper.toEntity(medecinDTO);
        medecin.setId(id);
        Medecin savedMedecin=medecinRepository.save(medecin);

        // Update corresponding User account if email changed or password is provided
        if (oldEmail != null) {
            userRepository.findByEmail(oldEmail).ifPresent(user -> {
                user.setUsername(medecinDTO.getNom());
                user.setEmail(medecinDTO.getEmail());
                if (medecinDTO.getPassword() != null && !medecinDTO.getPassword().isBlank()) {
                    user.setPassword(passwordEncoder.encode(medecinDTO.getPassword()));
                }
                userRepository.save(user);
            });
        }
        return medecinMapper.toDTO(savedMedecin);

    }
    @CacheEvict(value="medecins",allEntries = true)

    public void supprimerMedecin(long id){
        Medecin medecin = medecinRepository.findById(id).orElseThrow(() -> new RuntimeException("Erreur"));
        if (medecin.getEmail() != null) {
            userRepository.findByEmail(medecin.getEmail()).ifPresent(userRepository::delete);
        }
        medecinRepository.deleteById(id);

    }
    @Cacheable(value="medecins",key="'all'")
    public List<MedecinDTO>listerMedecins(){
        System.out.println("==============lister medecins======================");
        List<Medecin>medecinList=medecinRepository.findAll();
        return medecinMapper.toDTOList(medecinList);
    }

    public Page<MedecinDTO> listerMedecins(int page, int size){
        return medecinRepository.findAll(PageRequest.of(page, size)).map(medecinMapper::toDTO);
    }
}

package org.example.healthcare_s.repository;

import org.example.healthcare_s.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository  extends JpaRepository<Medecin,Long> {
}

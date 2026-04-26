package org.example.healthcare_s.repository;

import org.example.healthcare_s.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository  extends JpaRepository<RendezVous,Long> {
}

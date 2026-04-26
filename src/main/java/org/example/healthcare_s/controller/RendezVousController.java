package org.example.healthcare_s.controller;

import org.example.healthcare_s.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   RendezVousController extends JpaRepository<RendezVous,Long> {
}

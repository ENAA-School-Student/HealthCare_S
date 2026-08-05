package org.example.healthcare_s.repository;

import org.example.healthcare_s.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findAllByOrderByNomDesc(Pageable pageable);
    Page<Patient> findByNom (String nom ,Pageable pageable);
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.rendezVous WHERE p.id = :id")
    Optional<Patient> findById(@Param("id") Long id);

//    Patient findPatientByNomOrPrenom(String nom, String prenom);

    @Query(value = "SELECT * FROM PATIENT WHERE  NOM LIKE '%nom%' OR PRENOM  LIKE '%nom%'",nativeQuery = true )
    Patient findPatientByNomOrPrenom(String nom);





}

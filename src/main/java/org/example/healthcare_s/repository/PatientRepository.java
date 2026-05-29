package org.example.healthcare_s.repository;

import org.example.healthcare_s.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findAllByOrderByNomDesc(Pageable pageable);
    Page<Patient> findByNom (String nom ,Pageable pageable);

}

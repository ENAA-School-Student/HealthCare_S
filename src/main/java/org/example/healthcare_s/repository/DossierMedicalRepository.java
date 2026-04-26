package org.example.healthcare_s.repository;

import org.example.healthcare_s.entity.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Long> {

}

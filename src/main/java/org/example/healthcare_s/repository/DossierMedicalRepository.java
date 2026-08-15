package org.example.healthcare_s.repository;

import org.example.healthcare_s.entity.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Long> {
    Boolean existsByPatientId(long patientId);

    @Modifying
    @Transactional
    @Query("DELETE FROM DossierMedical d WHERE d.patient.id = :patientId")
    void deleteByPatientId(@Param("patientId") Long patientId);
}

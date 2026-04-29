package org.example.healthcare_s.repository;

import jakarta.transaction.Transactional;
import org.example.healthcare_s.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository  extends JpaRepository<RendezVous,Long> {

    @Modifying
    @Transactional
    @Query(value="update rendez_vous set statut ='annule' where id=:id",nativeQuery = true)
    int modifierStatutRendezVous(@Param("id")Long id );


    @Query(value="SELECT * FROM rendez_vous r where r.patient_id=:id",nativeQuery = true)
    List<RendezVous> rechercherRendezVousParPatient(@Param("id")long id);
    @Query(value="SELECT * FROM rendez_vous r  where r.medecin_id=:id",nativeQuery = true)
    List<RendezVous>rechercherRendezVousParmedecin(@Param("id")long id);


}

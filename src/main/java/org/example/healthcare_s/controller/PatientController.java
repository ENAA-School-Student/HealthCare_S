package org.example.healthcare_s.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.dto.PatientDTO;
import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.repository.PatientRepository;
import org.example.healthcare_s.service.GenerationPdf;
import org.example.healthcare_s.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final  PatientService patientService;
    private final PatientRepository patientRepository;
    private final GenerationPdf generationPdf;
    @PostMapping
    public ResponseEntity<PatientDTO>ajouterPatient(@Valid @RequestBody PatientDTO patientDTO){
        return ResponseEntity.ok(patientService.ajouterPatient(patientDTO));

    }
@GetMapping("/count")
public long count(){
        return patientService.count();
}

    @GetMapping
    public List<PatientDTO>listerPatients(){
        return patientService.listerPatients();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO>modifierPatient(@PathVariable long id,@Valid @RequestBody PatientDTO patientDTO){
        return ResponseEntity.ok(patientService.modifierPatient(id,patientDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerPatient(@PathVariable long id){
        patientService.supprimerPatient(id);
        return ResponseEntity.ok().build();
   }
   @GetMapping("/{id}")
    public ResponseEntity<PatientDTO>consulterPatient(@PathVariable long id){
        return ResponseEntity.ok(patientService.consulterPatient(id));
   }
   @GetMapping("/{id}/rendezvous/download")
    public ResponseEntity<byte[]> downloadRendezVousPdf(@PathVariable long id){
       Patient patient = patientRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Patient non trouvé avec l'id : " + id));
       byte[]pdfBytes=generationPdf.genererPdfRendezVousPatient(patient);
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_PDF);
       String patientNom = patient.getNom().replaceAll("\\s+", "_");
       String filename = "rendezvous_" + patientNom + "_" + id + ".pdf";
       headers.setContentDispositionFormData("attachment", filename);
       headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
       return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
       
    }
//
//    @GetMapping("/PatientsNomDec")
//    ResponseEntity<Page<PatientDTO>> findAllPatientByNomDesc(
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "20") int size
//    ) {
//
//        Page<PatientDTO> patients = patientService.findAllByOrderByNomDesc(size,page);
//        return ResponseEntity.ok(patients);
//    }
//
//    @GetMapping("/PatientsNom")
//    ResponseEntity<Page<PatientDTO>> findByNom(
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "20") int size,
//            @RequestParam String nom
//    ) {
//
//        Page<PatientDTO> patients = patientService.findByNom(nom,size,page);
//        return ResponseEntity.ok(patients);
//    }


    @GetMapping("/patientPagines")
    public Page<PatientDTO> getPatientsPagines(Pageable pageable){
        return patientService.getPatientsPagines(pageable);
    }


}

package org.example.healthcare_s.service;



import org.example.healthcare_s.entity.Patient;
import org.example.healthcare_s.entity.RendezVous;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class GenerationPdf{
    public byte[] genererPdfRendezVousPatient(Patient patient) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, out);
            document.open();


            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Liste des Rendez-vous", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(15);
            document.add(title);

            Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 11);
            document.add(new Paragraph("Patient :" + patient.getNom()+patient.getPrenom(), infoFont));
            document.add(new Paragraph("Téléphone :" + patient.getTelephone(), infoFont));

            document.add(new Paragraph("Email : " + patient.getEmail(), infoFont));
            document.add(new Paragraph("-----------------------------------------------------------------------------------"));
            document.add(new Paragraph(" "));


            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);


            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            PdfPCell cell;

            cell = new PdfPCell(new Phrase("Date", headFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Patient", headFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Statut", headFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


            List<RendezVous> listeRdv = patient.getRendezVous();
            if (listeRdv != null && !listeRdv.isEmpty()) {
                for (RendezVous rdv : listeRdv) {
                    table.addCell(rdv.getDateRendezVous().toString());
                    table.addCell(rdv.getPatient() != null ? rdv.getPatient().getNom() : "N/A");
                    table.addCell(rdv.getStatut());
                }
            } else {
                PdfPCell emptyCell = new PdfPCell(new Phrase("Aucun rendez-vous planifié."));
                emptyCell.setColspan(3);
                emptyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(emptyCell);
            }

            document.add(table);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }



}
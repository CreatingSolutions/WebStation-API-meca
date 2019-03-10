package webstationapi.Service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.LiftBooking;
import webstationapi.Repository.LiftBookingRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class LiftBookingService {

    private LiftBookingRepository liftBookingRepository;

    @Autowired
    private LiftService liftService;

    public LiftBookingService(LiftBookingRepository liftBookingRepository) {
        this.liftBookingRepository = liftBookingRepository;
    }

    public List<LiftBooking> getAllBookByUser(Long id) {
        return this.liftBookingRepository.findAllByIdUser(id);
    }

    @Transactional
    public void makeBook(List<LiftDTO> liftDTOS, Long idUser) {

        for (LiftDTO liftDTO : liftDTOS) {
            LiftBooking liftBooking = new LiftBooking();
            liftBooking.setDiamond(liftDTO.isDiamond());
            liftBooking.setIdLift(liftDTO.getId());
            liftBooking.setIdUser(idUser);
            liftBooking.setInsurrance(liftDTO.isInsurrance());
            liftBooking.setNbFois(liftDTO.getNbFois());
            liftBooking.setValid(false);
            liftBooking.setPrice(this.liftService.calculePrice(Arrays.asList(liftDTO)));
            this.liftBookingRepository.save(liftBooking);
        }

    }

    public Document makePdf(Long iduser) throws FileNotFoundException, DocumentException {
        List<LiftBooking> allBookByUser = this.getAllBookByUser(iduser);

        Document document = new Document();
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString() + ".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(name));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph();


        Chunk chunk = new Chunk("Facture : " + uuid.toString(), font);
        paragraph.add(chunk);
        paragraph.add(Chunk.NEWLINE);

        Double fullPrice = 0.0;

        for (LiftBooking liftBooking : allBookByUser) {
            String line = liftBooking.getIdLift().toString() + " " + liftBooking.getNbFois() + " = " + liftBooking.getPrice().toString();
            fullPrice += liftBooking.getPrice();
            Chunk tmpChunk = new Chunk(line, font);
            paragraph.add(tmpChunk);
            paragraph.add(Chunk.NEWLINE);
        }

        Chunk finalChunk = new Chunk("Total Price " + fullPrice.toString(), font);
        paragraph.add(finalChunk);
        document.add(paragraph);

        document.close();
        return document;
    }
}

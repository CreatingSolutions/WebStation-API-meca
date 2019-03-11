package webstationapi.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.LiftBooking;
import webstationapi.Service.LiftBookingService;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("liftbooking")
public class LiftBookingController {

    @Autowired
    private LiftBookingService liftBookingService;

    @GetMapping("{id}")
    public List<LiftBooking> getActiveBookByUser(@PathVariable Long id) {
        return this.liftBookingService.getAllBookByUser(id);
    }

    @PostMapping("{idUser}")
    public void makeBook(@RequestBody List<LiftDTO> liftDTOS, @PathVariable Long idUser){
        this.liftBookingService.makeBook(liftDTOS, idUser);
    }
}

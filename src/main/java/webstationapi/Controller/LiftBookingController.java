package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Entity.LiftBooking;
import webstationapi.Service.LiftService;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("liftbook")
public class LiftBookingController {

    @Autowired
    private LiftService liftService;

    @GetMapping("/{iduser}")
    public List<LiftBooking> getcart(@PathVariable("iduser") int iduser) {
        return this.liftService.getcart(iduser);
    }

}

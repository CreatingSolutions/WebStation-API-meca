package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Service.ReservationService;

@RestController
@EnableAutoConfiguration
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

}

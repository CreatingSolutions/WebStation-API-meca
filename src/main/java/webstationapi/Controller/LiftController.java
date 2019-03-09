package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;
import webstationapi.Service.LiftService;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class LiftController {

    @Autowired
    private LiftService liftService;

    @GetMapping("lift/{id}")
    public Lift getLift(@PathVariable Long id) {
        return liftService.findById(id);
    }

    @GetMapping("lifts")
    public List<Lift> getLiftByTypeAndAge(@RequestParam(value = "type") TypeEnum type, @RequestParam(value = "age") AgeEnum age) {
        return this.liftService.findByTypeAndAge(type, age);
    }

}

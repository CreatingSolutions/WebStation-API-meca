package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.LiftPriceDTO;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;
import webstationapi.Service.LiftService;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("lift")
public class LiftController {

    @Autowired
    private LiftService liftService;

    @GetMapping("{id}")
    public Lift getLift(@PathVariable Long id) {
        return liftService.findById(id);
    }

    @GetMapping
    public List<Lift> getLiftByTypeAndAge(@RequestParam(value = "type") TypeEnum type, @RequestParam(value = "age") AgeEnum age) {
        return this.liftService.findByTypeAndAge(type, age);
    }

    @PostMapping("price")
    public Double getCalculePrice(@RequestBody List<LiftPriceDTO> liftPriceDTOS) {
        return this.liftService.calculePrice(liftPriceDTOS);
    }

}

package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.LiftDTO;
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
    public LiftDTO getLiftByTypeAndAge(@RequestParam(value = "type") TypeEnum type, @RequestParam(value = "age", required = false) AgeEnum age) {

        List<Lift> normal = this.liftService.findByTypeAndAge(type, age, false);
        List<Lift> diamond = this.liftService.findByTypeAndAge(type, age, true);

        LiftDTO liftDTO = new LiftDTO();
        liftDTO.setDescription(normal.get(0).getDescription());
        liftDTO.setNormal(this.liftService.buildForfait(normal));
        liftDTO.setDiamant(this.liftService.buildForfait(diamond));

        return liftDTO;
    }

    @PostMapping("price")
    public Double getCalculePrice(@RequestBody List<LiftDTO> liftDTOS) {
        return this.liftService.calculePrice(liftDTOS);
    }

}

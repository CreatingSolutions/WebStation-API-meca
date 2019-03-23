package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.ForfaitDTO;
import webstationapi.DTO.LiftBookDTO;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.Lift;
import webstationapi.Entity.LiftBooking;
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

        if (type.equals(TypeEnum.TELESIEGE)) {
            List<Lift> normal = this.liftService.findtelesiege(type);
            LiftDTO liftDTO = new LiftDTO();
            liftDTO.setDescription(normal.get(0).getDescription());

            ForfaitDTO unit = new ForfaitDTO();
            unit.setPrices(normal.get(0).getPrice_unit());
            unit.setId(normal.get(0).getId());
            unit.setLabel(normal.get(0).getLabel());

            ForfaitDTO group = new ForfaitDTO();
            group.setPrices(normal.get(1).getPrice_group());
            group.setId(normal.get(1).getId());
            group.setLabel(normal.get(1).getLabel());

            liftDTO.setUnitaire(unit);
            liftDTO.setGroupe(group);
            return liftDTO;
        } else {

            List<Lift> normal = this.liftService.findByTypeAndAge(type, age, false);
            List<Lift> diamond = this.liftService.findByTypeAndAge(type, age, true);

            LiftDTO liftDTO = new LiftDTO();
            liftDTO.setDescription(normal.get(0).getDescription());
            liftDTO.setNormal(this.liftService.buildForfait(normal));
            liftDTO.setDiamant(this.liftService.buildForfait(diamond));
            return liftDTO;
        }
    }

    @PostMapping("price")
    public Double getCalculePrice(@RequestBody List<LiftDTO> liftDTOS) {
        return this.liftService.calculePrice(liftDTOS);
    }

    @PostMapping("/add")
    public Long addToCart(@RequestBody LiftBookDTO liftBookDTO) {

        Long id = this.liftService.addcart(liftBookDTO);

        return id;
    }

    @GetMapping("/b/{iduser}")
    public List<LiftBooking> getcart(@PathVariable int iduser){

    }

}

package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.TelesiegeDTO;
import webstationapi.Entity.Telesiege;
import webstationapi.Service.TelesiegeService;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("telesiege")
public class TelesiegeController {

    @Autowired
    private TelesiegeService telesiegeService;

    @GetMapping("{id}")
    public Telesiege getTelesiege(@PathVariable Long id) {
        return this.telesiegeService.findById(id);
    }

    @GetMapping
    public List<Telesiege> getTelesieges() {
        return this.telesiegeService.findAll();
    }

    @PostMapping("price")
    public Double getCalculatePrice(@RequestBody List<TelesiegeDTO> telesieges) {
        return this.telesiegeService.getPrice(telesieges);
    }
}
package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Entity.Telesiege;
import webstationapi.Service.TelesiegeService;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class TelesiegeController {

    @Autowired
    private TelesiegeService telesiegeService;

    @GetMapping("telesiege/{id}")
    public Telesiege getTelesiege(@PathVariable Long id) {
        return this.telesiegeService.findById(id);
    }

    @GetMapping("telesieges")
    public List<Telesiege> getTelesieges() {
        return this.telesiegeService.findAll();
    }

}
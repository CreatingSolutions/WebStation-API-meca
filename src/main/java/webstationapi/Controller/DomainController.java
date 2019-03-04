package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.Service.DomainService;

@RestController
@EnableAutoConfiguration
public class DomainController {

    @Autowired
    private DomainService domainService;

}

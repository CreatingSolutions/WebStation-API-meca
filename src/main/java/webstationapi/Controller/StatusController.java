package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
public class StatusController {


    @Value("api.api")
    private String apiUrl;

    @GetMapping("/status")
    @ResponseBody
    public String sendViaResponseEntity() {

        return "ok";
        /*
        final String uri = "http://localhost:8081/status";

        RestTemplate restTemplate = new RestTemplate();

        String ret = restTemplate.getForObject(uri, String.class);

        System.out.println("Result --- " + ret);

        return new ResponseEntity<>(HttpStatus.CREATED);
    */
    }

}

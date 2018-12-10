package lunch.api;

import lunch.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

public class IotApi {

    private String friebaseUrl = "https://lunch-iot.firebaseio.com";



    @RequestMapping("/rfid/{serialNumber}")
    public void createRFIDEvent(@PathVariable String serialNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = friebaseUrl + "/events.json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
    }
}

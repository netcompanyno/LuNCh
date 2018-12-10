package lunch.api;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import lunch.model.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppApi {

    private String friebaseUrl = "https://lunch-iot.firebaseio.com";

    @RequestMapping("/person/{shortName}")
    public Person getPerson(@PathVariable String shortName) {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl = String.format("%s/persons.json?orderBy=\"shortName\"&equalTo=\"%s\"", friebaseUrl, shortName);

        System.out.println(resourceUrl);

        Map<String, Person> response = restTemplate.getForObject(resourceUrl, Map.class);

        System.out.println(response.get("-LP1i_tYAiSUXDZlaeyU"));
        return response.get("-LP1i_tYAiSUXDZlaeyU");
    }


    @RequestMapping("/createPerson/{shortName}")
    public Person createPerson(@PathVariable String shortName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(new Person(shortName, "1234"));

        String resourceUrl = String.format("%s/persons.json", friebaseUrl);

        Person person = restTemplate.postForObject(resourceUrl, request, Person.class);
        return person;
    }

    @RequestMapping("/person")
    public Person getPersonBySerialNumber(@RequestParam String serialNumber) {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl = String.format("%s/persons.json?orderBy=\"serialNumber\"&equalTo=%s", friebaseUrl, serialNumber);

        ResponseEntity<Person> response
                = restTemplate.getForEntity(resourceUrl, Person.class);
        return response.getBody();
    }
}
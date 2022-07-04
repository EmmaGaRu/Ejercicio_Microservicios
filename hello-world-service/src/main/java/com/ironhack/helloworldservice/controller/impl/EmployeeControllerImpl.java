package com.ironhack.helloworldservice.controller.impl;

import com.ironhack.helloworldservice.controller.interfaces.HelloWorldController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private DiscoveryClient discoveryClient;

   // private final Logger logger = LoggerFactory.getLogger(HelloWorldControllerImpl.class);

    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee() {
        Employee employee1 = new Employee("", "ventas", 30000);
//Las siguientes 2 líneas sirven para traerte al servicio del nombre, no del servidor!
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = discoveryClient.getInstances("name-service").get(0).getUri().toString();
        logger.info("Base url = " + baseUrl);//Esta línea es solo informativa

        String apiMethod = "/name";

        String result = restTemplate.getForObject(baseUrl + apiMethod, String.class);
        employee1.setName(result);
        return employee1;
    }


}

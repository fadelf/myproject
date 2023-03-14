package com.delfa.demo.service.impl;


import com.delfa.demo.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PetServiceImpl implements PetService {

    @Override
    public String getPetByStatus(String status) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://petstore3.swagger.io/api/v3/pet/findByStatus?status={status}";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, status);

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            return responseBody;
        } else {
            return "Error from APIs";
        }
    }
}

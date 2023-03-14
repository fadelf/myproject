package com.delfa.demo.service.impl;


import com.delfa.demo.service.PetService;
import com.delfa.demo.wrapper.PetData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Override
    public List<PetData> getPetByStatus(String status) {
        List<PetData> petList = new ArrayList<>();
        String[] validStatus = {"available", "sold", "pending"};
        List<String> statusList = Arrays.asList(validStatus);

        if (status == null || status.isEmpty()) {
            return petList;
        }

        if (!statusList.contains(status.toLowerCase())) {
            return petList;
        }

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://petstore3.swagger.io/api/v3/pet/findByStatus?status={status}";

        ResponseEntity<List<PetData>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                },
                status);

        if (response.getStatusCode() == HttpStatus.OK) {
            petList = response.getBody();
        }
        return petList;
    }
}

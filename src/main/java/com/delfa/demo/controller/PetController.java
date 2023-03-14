package com.delfa.demo.controller;

import com.delfa.demo.service.PetService;
import com.delfa.demo.wrapper.PetData;
import com.delfa.demo.wrapper.PetResponse;
import com.delfa.demo.wrapper.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @Operation(description = "Find pet by status (available, sold, pending)")
    @RequestMapping(path = "/find/{status}", method = RequestMethod.GET)
    public ResponseEntity<?> getPetByStatus(@PathVariable String status) {
        PetResponse response = new PetResponse();
        StatusResponse statusResponse = new StatusResponse();
        List<PetData> petList = petService.getPetByStatus(status);

        if (petList.size() != 0) {
            statusResponse.setCode("200");
            statusResponse.setMessage("Success");

            response.setStatus(statusResponse);
            response.setResult(petList);
        } else {
            statusResponse.setCode("200");
            statusResponse.setMessage("Pet data not found!");

            response.setStatus(statusResponse);
            response.setResult(petList);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

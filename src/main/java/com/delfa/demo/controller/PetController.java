package com.delfa.demo.controller;

import com.delfa.demo.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(path = "/find/{status}", method = RequestMethod.GET)
    public ResponseEntity<?> getPetByStatus(@PathVariable String status) {
        String response = petService.getPetByStatus(status);

        return new ResponseEntity<>("Result: " + response, HttpStatus.OK);
    }
}

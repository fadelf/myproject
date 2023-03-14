package com.delfa.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ResponseEntity<?> getTest() {
        return new ResponseEntity<>("Welcome to Home Page", HttpStatus.OK);
    }
}

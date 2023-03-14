package com.delfa.demo.controller;

import com.delfa.demo.service.impl.AuthenticationService;
import com.delfa.demo.wrapper.auth.AuthenticationRequest;
import com.delfa.demo.wrapper.auth.AuthenticationResponse;
import com.delfa.demo.wrapper.auth.RegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(path = "/register",
            method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request) {
        AuthenticationResponse response = authenticationService.register(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/authenticate",
            method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUSer(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

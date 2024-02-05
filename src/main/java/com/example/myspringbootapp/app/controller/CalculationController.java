package com.example.myspringbootapp.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculationController {

    @RequestMapping(method = RequestMethod.GET, path = "/calculation")
    public ResponseEntity<String> testGetRequest() {
        return ResponseEntity.ok("GET request successful");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/calculation")
    public ResponseEntity<String> testPostRequest() {
        // TODO: Connect the service
        return ResponseEntity.ok("POST request successful");
    }
}

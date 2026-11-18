package com.taller7.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller7.api.model.Name;
import com.taller7.api.repository.NameRepository;

@RestController 
@RequestMapping("/api/v1") // Base URL path for everything inside
public class NameController {

    private final NameRepository repository;

    // Spring automatically hands ("injects") the repository into this controller
    public NameController(NameRepository repository) {
        this.repository = repository;
    }

    // Runs when someone sends a POST request to /api/v1/hello
    @PostMapping("/hello")
    public Name createName(@RequestBody Name incomingData) {
        // Saves the incoming JSON directly into PostgreSQL and returns the saved row (with its new ID)
        return repository.save(incomingData);
    }

    // Runs when someone sends a GET request to /api/v1/hello
    @GetMapping("/hello")
    public List<Name> getAllNames() {
        // Fetches every row from the 'greetings' table as a JSON list
        return repository.findAll();
    }
}
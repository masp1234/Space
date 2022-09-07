package com.example.space.planet.controller;

import com.example.space.customer.model.Customer;
import com.example.space.customer.repository.CustomerRepository;
import com.example.space.planet.model.Planet;
import com.example.space.planet.repository.PlanetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/planets")
public class PlanetController {
    PlanetRepository planetRepository;

    PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findCustomerById(@PathVariable("id") Long id){
        Optional<Planet> planet = Optional.of(planetRepository.findById(id).orElseThrow(() -> new RuntimeException("not found")));
        System.out.println(planet.get());
        return ResponseEntity.ok().body(planet.get());
    }

}

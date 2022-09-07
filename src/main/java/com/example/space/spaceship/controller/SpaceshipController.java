package com.example.space.spaceship.controller;

import com.example.space.spaceship.model.Spaceship;
import com.example.space.spaceship.repository.SpaceshipRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/spaceships")
public class SpaceshipController {

    private SpaceshipRepository spaceshipRepository;

    public SpaceshipController(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spaceship> findSpaceshipById(@PathVariable("id") Long id) {
        Optional<Spaceship> spaceship = Optional.of(spaceshipRepository.findById(id).orElseThrow(() -> new RuntimeException("not found")));
    return ResponseEntity.ok().body(spaceship.get());
    }
}

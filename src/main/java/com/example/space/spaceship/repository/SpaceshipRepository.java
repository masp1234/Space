package com.example.space.spaceship.repository;

import com.example.space.spaceship.model.Spaceship;
import org.springframework.data.repository.CrudRepository;

public interface SpaceshipRepository extends CrudRepository<Spaceship, Long> {
}

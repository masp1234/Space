package com.example.space.planettype.model;

import com.example.space.planet.model.Planet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "planet_type")
public class PlanetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @JsonBackReference
    @ManyToMany(mappedBy = "planetTypes", fetch = FetchType.EAGER)
    private List<Planet> planets;

    public PlanetType(String type) {
        this.type = type;
    }

    public PlanetType() {

    }

    @Override
    public String toString() {
        return "id: " + id + " type: " + type;
    }
}




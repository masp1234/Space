package com.example.space.planettype;

import com.example.space.planet.model.Planet;

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

    @ManyToMany(mappedBy = "planetTypes")
    private List<Planet> planets;

}




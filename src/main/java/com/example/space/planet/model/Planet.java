package com.example.space.planet.model;


import com.example.space.planettype.model.PlanetType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mass")
    private double mass;

    @Column(name = "diameter_in_kilometers")
    private double diameterInKilometers;

    @Column(name = "density_in_kilograms_per_cubic_meter")
    private double densityInKilogramsPerCubicMeter;

    @Column(name = "gravity")
    private double gravity;

    @Column(name = "length_of_day")
    private double LengthOfDayInHours;

    @Column(name = "distance_from_sun")
    private double distanceFromSun;

    @Column(name = "mean_temperature_in_celsius")
    private double meanTemperaturInCelsius;

    @Column(name = "number_of_moons")
    private int numberOfMoons;



    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "planet_planet_type",
                joinColumns = {@JoinColumn(name = "planet_id")},
            inverseJoinColumns = {@JoinColumn(name = "planet_type_id")}
    )
    private List<PlanetType> planetTypes;

    public Planet(
            String name,
            double mass,
            double diameterInKilometers,
            double densityInKilogramsPerCubicMeter,
            double gravity,
            double lengthOfDayInHours,
            double distanceFromSun,
            double meanTemperaturInCelsius,
            int numberOfMoons,
            List<PlanetType> planetTypes
    ) {
        this.mass = mass;
        this.diameterInKilometers = diameterInKilometers;
        this.densityInKilogramsPerCubicMeter = densityInKilogramsPerCubicMeter;
        this.gravity = gravity;
        LengthOfDayInHours = lengthOfDayInHours;
        this.distanceFromSun = distanceFromSun;
        this.meanTemperaturInCelsius = meanTemperaturInCelsius;
        this.numberOfMoons = numberOfMoons;
        this.planetTypes = planetTypes;
    }


    public Planet() {

    }
}

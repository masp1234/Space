package com.example.space.planet.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


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



}

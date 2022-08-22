package com.example.space.spaceship.model;


import javax.persistence.*;

@Entity
@Table(name = "spaceship")
public class Spaceship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "speed")
    private double speed;


    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "name")
    private String name;





}

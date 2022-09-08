package com.example.space.spaceship.model;


import com.example.space.reservation.model.Reservation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "spaceship")
public class Spaceship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "speed")
    private double speed;


    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany
    private List<Reservation> reservations;

    public Spaceship(List<Reservation> reservations) {
        this.speed = speed;
        this.numberOfSeats = numberOfSeats;
        this.name = name;
        this.reservations = reservations;
    }

    public Spaceship() {

    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "id=" + id +
                ", speed=" + speed +
                ", numberOfSeats=" + numberOfSeats +
                ", name='" + name + '\'' +
                '}';
    }
}

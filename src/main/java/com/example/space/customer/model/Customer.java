package com.example.space.customer.model;


import com.example.space.reservation.model.Reservation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table(name = "customer")

public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    public List<Reservation> getReservations() {
        return reservations;
    }

    @JsonBackReference
    @ManyToMany(mappedBy = "customers")
    private List<Reservation> reservations = new ArrayList<>();




    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Customer(String firstName, String lastName, int age, List<Reservation> reservations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.reservations = reservations;
    }

    public Customer() {

    }
}

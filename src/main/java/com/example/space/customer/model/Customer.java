package com.example.space.customer.model;


import com.example.space.reservation.model.Reservation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

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

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @ManyToMany(mappedBy = "customers")
    private ArrayList<Reservation> reservations = new ArrayList<>();




    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Customer() {

    }
}

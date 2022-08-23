package com.example.space.reservation.model;

import com.example.space.customer.model.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@ToString

@Entity
@Table(name = "reservation")

public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_reservation",
               joinColumns = {@JoinColumn(name = "reservation_id")},
               inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}

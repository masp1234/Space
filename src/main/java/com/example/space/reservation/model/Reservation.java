package com.example.space.reservation.model;

import com.example.space.customer.model.Customer;
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
@Table(name = "reservation")

public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "customer_reservation",
               joinColumns = {@JoinColumn(name = "reservation_id")},
               inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private List<Customer> customers = new ArrayList<>();

    public Reservation(List<Customer> customers) {
        this.customers = customers;
    }
    public Reservation() {

    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

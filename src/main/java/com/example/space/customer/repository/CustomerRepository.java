package com.example.space.customer.repository;

import com.example.space.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    ArrayList<Customer> findByFirstName(String name);

    ArrayList<Customer> findByAgeGreaterThan(int minimumAge);

    ArrayList<Customer> findByLastNameStartingWith(String startingWith);
}

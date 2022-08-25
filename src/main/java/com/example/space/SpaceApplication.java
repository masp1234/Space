package com.example.space;

import com.example.space.customer.model.Customer;
import com.example.space.customer.repository.CustomerRepository;
import com.example.space.reservation.model.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpaceApplication {

    private static final Logger log = LoggerFactory.getLogger((SpaceApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(SpaceApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(

            CustomerRepository customerRepository) {

        return (args) -> {
            /**
             *  Save a few customers
             */
            final List<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Jack", "Bauer", 26));
            customers.add(new Customer("Chloe", "O'Brian", 28));
            customers.add(new Customer("Kim", "Bauer", 22));
            customers.add(new Customer("David", "Palme", 65));
            customers.add(new Customer("Michelle", "Dessler", 87));
            customerRepository.saveAll(customers);

        };
    }
}

/*
    @Bean
    public CommandLineRunner importData(

            CustomerRepository customerRepository
    ) {
        return args -> {
            final List<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Jack", "Bauer", 20));
            customers.add(new Customer("Chloe", "O'Brian", 18));
            customers.add(new Customer("Kim", "Bauer", 5));
            customers.add(new Customer("David", "Palmer", 55));
            customers.add(new Customer("Michelle", "Dessler", 43));
            customerRepository.saveAll(customers);

            ArrayList<Customer> customersByFirstName = customerRepository.findByFirstName("Jack");
            for (Customer customer : customersByFirstName) {
                System.out.println(customer);
            }

            ArrayList<Customer> customersByACertainAge = customerRepository.findByAgeGreaterThan(30);
            System.out.println(customersByACertainAge);


            ArrayList<Customer> customersWithNameLike = customerRepository.findByLastNameStartingWith("P");
            System.out.println(customersWithNameLike);
        };
        */





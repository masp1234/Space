package com.example.space;

import com.example.space.customer.model.Customer;
import com.example.space.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpaceApplication implements CommandLineRunner{

    CustomerRepository customerRepository;

    public SpaceApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpaceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jack", "Bauer", 20));
        customers.add(new Customer("Chloe", "O'Brian", 18));
        customers.add(new Customer("Kim", "Bauer", 5));
        customers.add(new Customer("David", "Palmer", 55));
        customers.add(new Customer("Michelle", "Dessler", 43));
        customerRepository.saveAll(customers);

        ArrayList<Customer> customersByFirstName = customerRepository.findByFirstName("Jack");
        for (Customer customer: customersByFirstName) {
            System.out.println(customer);
        }

        ArrayList<Customer> customersByACertainAge = customerRepository.findByAgeGreaterThan(30);
        System.out.println(customersByACertainAge);


        ArrayList<Customer> customersWithNameLike = customerRepository.findByLastNameStartingWith("P");
        System.out.println(customersWithNameLike);
    }
}

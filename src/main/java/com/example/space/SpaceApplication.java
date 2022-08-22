package com.example.space;

import com.example.space.customer.model.Customer;
import com.example.space.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        customers.add(new Customer("Jack", "Bauer"));
        customers.add(new Customer("Chloe", "O'Brian"));
        customers.add(new Customer("Kim", "Bauer"));
        customers.add(new Customer("David", "Palmer"));
        customers.add(new Customer("Michelle", "Dessler"));
        customerRepository.saveAll(customers);

        ArrayList<Customer> customersByFirstName = customerRepository.findByFirstName("Jack");
        for (Customer customer: customersByFirstName) {
            System.out.println(customer);
        }
    }
}

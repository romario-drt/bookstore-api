package com.romario.bookstore_api.service;

import com.romario.bookstore_api.model.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById ( Integer id );

    Customer findByEmail ( String email );

    Customer save (Customer customer);

    boolean existsByEmail (String email);

}



package com.romario.bookstore_api.service.impl;

import com.romario.bookstore_api.exception.NotFoundException;
import com.romario.bookstore_api.model.entity.Customer;
import com.romario.bookstore_api.repository.CustomerRepo;
import com.romario.bookstore_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email).orElseThrow( () -> new NotFoundException("customer"));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepo.existsByEmail(email);
    }
}

package com.romario.bookstore_api.repository;

import com.romario.bookstore_api.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c where c.email = :email")
    Optional<Customer> findByEmail( @Param("email") String email);

    boolean existsByEmail(String email);

}
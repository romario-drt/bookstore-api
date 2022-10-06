package com.romario.bookstore_api.repository;

import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepo extends PagingAndSortingRepository<Book, Integer> {



}
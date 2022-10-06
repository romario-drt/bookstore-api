package com.romario.bookstore_api.service;

import com.romario.bookstore_api.model.entity.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> findById (Integer id );

    Optional<Book> findByTitle (String title);

    Book save (Book book);

    boolean existsByTitle (String title);

}



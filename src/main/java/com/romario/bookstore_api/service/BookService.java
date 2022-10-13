package com.romario.bookstore_api.service;

import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.request.BookFilterReq;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findByTitle (String title);

    Book save (Book book);

    List<Book> findBySpecification(BookFilterReq filters);


}



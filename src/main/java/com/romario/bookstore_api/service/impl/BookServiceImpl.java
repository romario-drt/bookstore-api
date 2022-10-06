package com.romario.bookstore_api.service.impl;

import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }
}

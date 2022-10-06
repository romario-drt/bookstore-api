package com.romario.bookstore_api.service.impl;

import com.romario.bookstore_api.exception.NotFoundException;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.repository.BooksRepo;
import com.romario.bookstore_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BooksRepo booksRepo;

    @Override
    public Book findById(Integer id) {
        return booksRepo.findById(id).orElseThrow( () -> new NotFoundException("Book"));
    }

    @Override
    public Book findByTitle(String title) {
        return booksRepo.findByTitle(title).orElseThrow( () -> new NotFoundException("Book"));
    }

    @Override
    public Book save(Book book) {
        return booksRepo.save(book);
    }

    @Override
    public boolean existsByTitle(String title) {
        return booksRepo.existsByTitle(title);
    }
}

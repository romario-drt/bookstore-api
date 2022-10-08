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
    public Optional<Book> findByTitle(String title) {
        return booksRepo.findByTitle(title);
    }

    @Override
    public Book save(Book book) {
        return booksRepo.save(book);
    }

}

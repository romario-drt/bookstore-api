package com.romario.bookstore_api;

import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class BookstoreApiApplication implements CommandLineRunner {

    private final AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

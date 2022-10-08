package com.romario.bookstore_api.Controller;

import com.romario.bookstore_api.custom.converter.RepToBookConverter;
import com.romario.bookstore_api.exception.ExistingResource;
import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.entity.Genre;
import com.romario.bookstore_api.model.request.BookReq;
import com.romario.bookstore_api.service.AuthorService;
import com.romario.bookstore_api.service.BookService;
import com.romario.bookstore_api.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    private final RepToBookConverter converter;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@Valid @RequestBody BookReq request) {

        //check if book exists
        if (bookService.findByTitle(request.getTitle()).isPresent())
            throw new ExistingResource("Book", request.getTitle());

        Book toSave = converter.convert(request);
        toSave.setAuthors(new ArrayList<>());

        //handle gender
        genreService.findByGenre(request.getGenre().toUpperCase())
                .ifPresentOrElse(toSave::setGenre, () -> toSave.setGenre(new Genre(request.getGenre().toUpperCase())));

        //handle authors
        List<Author> foundAuthors = authorService.findIn(request.getAuthors());

        request.getAuthors().forEach(requestAuthor -> {
            Optional<Author> exists = foundAuthors.stream()
                    .filter(author -> author.getName().equalsIgnoreCase(requestAuthor)).findFirst();

            exists.ifPresentOrElse(toSave.getAuthors()::add, () -> toSave.getAuthors().add(new Author(requestAuthor)));
        });

        return bookService.save(toSave);
    }
}

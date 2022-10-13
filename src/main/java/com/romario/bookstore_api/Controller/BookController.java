package com.romario.bookstore_api.Controller;

import com.romario.bookstore_api.custom.converter.BookToResConverter;
import com.romario.bookstore_api.custom.converter.RepToBookConverter;
import com.romario.bookstore_api.exception.ExistingResource;
import com.romario.bookstore_api.exception.NotFoundException;
import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.entity.Genre;
import com.romario.bookstore_api.model.request.BookFilterReq;
import com.romario.bookstore_api.model.request.BookReq;
import com.romario.bookstore_api.model.response.BookResponse;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    private final RepToBookConverter converter;
    private final BookToResConverter bookResConverter;


    //get book by title
    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse findByTitle(@PathVariable String title) {
        Book found = bookService.findByTitle(title).orElseThrow(() -> new NotFoundException("Book"));
        return bookResConverter.convert(found);
    }

    //list books per specification
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findBySpecification(@Valid @RequestBody BookFilterReq request) {

        //since title is the where clause, it cannot be null.
        if(request.getTitle() == null) request.setTitle("");
        List<Book> foundBooks = bookService.findBySpecification(request);
        return foundBooks.stream().map(bookResConverter::convert).collect(Collectors.toList());
    }


    //save book
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse save(@Valid @RequestBody BookReq request) {

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
            foundAuthors.stream()
                    .filter(author -> author.getName().equalsIgnoreCase(requestAuthor))
                    .findFirst()
                    .ifPresentOrElse(toSave.getAuthors()::add, () -> toSave.getAuthors().add(new Author(requestAuthor)));
        });

        bookService.save(toSave);
        return bookResConverter.convert(toSave);
    }
}

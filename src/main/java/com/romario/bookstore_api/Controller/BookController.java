package com.romario.bookstore_api.Controller;

import com.romario.bookstore_api.custom.converter.RepToBookConverter;
import com.romario.bookstore_api.exception.ExistingResource;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.request.BookReq;
import com.romario.bookstore_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final RepToBookConverter converter;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@Valid @RequestBody BookReq request){

        if(bookService.existsByTitle(request.getTitle()))
            throw new ExistingResource("Book", request.getTitle());

        //TODO get the genre
        //TODO get the publisher
        //TODO get the authors

        Book toSave = converter.convert(request);
        return bookService.save(toSave);
    }
}

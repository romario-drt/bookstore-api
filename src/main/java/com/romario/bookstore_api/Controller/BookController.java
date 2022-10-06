package com.romario.bookstore_api.Controller;

import com.romario.bookstore_api.model.request.BookReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {



    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody BookReq request){
        System.out.println(request);
    }
}

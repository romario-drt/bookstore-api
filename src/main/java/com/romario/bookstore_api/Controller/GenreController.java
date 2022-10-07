package com.romario.bookstore_api.Controller;

import com.romario.bookstore_api.exception.ExistingResource;
import com.romario.bookstore_api.exception.NotFoundException;
import com.romario.bookstore_api.model.entity.Genre;
import com.romario.bookstore_api.model.request.GenreReq;
import com.romario.bookstore_api.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;


    //list all
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Genre> list() {
        return genreService.findAllGenres();
    }

    //get my name
    @GetMapping("/{name}")
    public Genre getByName(@PathVariable String name) {
        return genreService.findByGenre(name.toUpperCase()).orElseThrow(() -> new NotFoundException("Genre"));
    }

    //save
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre save(@RequestBody @Valid GenreReq genre) {

        String newGenre = genre.getGenre().toUpperCase();

        if (genreService.findByGenre(newGenre).isPresent())
            throw new ExistingResource("Genre", newGenre);

        return genreService.save(new Genre(newGenre));
    }

    //update
    @PutMapping("/{genre}")
    public Genre update(
            @RequestBody @Valid GenreReq reqBody,
            @PathVariable(name = "genre") String toUpdate
    ) {

        //TODO only admin users should be able to update genres

        Genre found = genreService.findByGenre(toUpdate.toUpperCase()).orElseThrow(() -> new NotFoundException("Genre"));
        found.setGenre(reqBody.getGenre().toUpperCase());
        return genreService.save(found);
    }

}

package com.romario.bookstore_api.service;


import com.romario.bookstore_api.model.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<Genre> findAllGenres();

    Optional<Genre> findByGenre(String name);

    Genre save(Genre genre);
}

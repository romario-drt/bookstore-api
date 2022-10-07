package com.romario.bookstore_api.service.impl;

import com.romario.bookstore_api.exception.NotFoundException;
import com.romario.bookstore_api.model.entity.Genre;
import com.romario.bookstore_api.repository.GenreRepo;
import com.romario.bookstore_api.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepo genreRepo;

    @Override
    public List<Genre> findAllGenres(){

        List<Genre> genreList = new ArrayList<>();
        genreRepo.findAll().forEach(genreList::add);
        return genreList;
    }

    @Override
    public Optional<Genre> findByGenre(String name){
        return genreRepo.findByGenre(name);
    }

    @Override
    public Genre save(Genre genre){
        genre.setGenre(genre.getGenre().toUpperCase());
        return genreRepo.save(genre);
    }
}

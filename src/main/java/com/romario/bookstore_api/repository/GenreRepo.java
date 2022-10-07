package com.romario.bookstore_api.repository;

import com.romario.bookstore_api.model.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepo extends CrudRepository<Genre, Integer> {

    Optional<Genre> findByGenre(String genre);
}

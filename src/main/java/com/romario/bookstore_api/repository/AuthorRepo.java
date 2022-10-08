package com.romario.bookstore_api.repository;

import com.romario.bookstore_api.model.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Integer> {

    List<Author> findByNameIn(Collection<String> name);
}

package com.romario.bookstore_api.service;

import com.romario.bookstore_api.model.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findIn(List<String> authors);
}

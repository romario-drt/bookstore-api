package com.romario.bookstore_api.service.impl;

import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.repository.AuthorRepo;
import com.romario.bookstore_api.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    @Override
    public List<Author> findIn(List<String> authors){
        return authorRepo.findByNameIn(authors);
    }

}

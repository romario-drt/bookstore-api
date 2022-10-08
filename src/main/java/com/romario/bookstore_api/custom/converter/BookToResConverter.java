package com.romario.bookstore_api.custom.converter;

import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.response.AuthorResponse;
import com.romario.bookstore_api.model.response.BookResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookToResConverter implements Converter<Book, BookResponse> {

    @Override
    public BookResponse convert(Book s) {

        BookResponse response = new BookResponse();

        response.setTitle(s.getTitle());
        response.setCondition(s.getCondition());
        response.setImg(s.getImg());
        response.setIsbn(s.getIsbn());
        response.setPrice(s.getPrice());
        response.setQuantity(s.getQuantity());
        response.setPublishedDate(s.getPublishedDate());

        response.setGenre(s.getGenre().getGenre());
        response.setAuthors(s.getAuthors()
                .stream()
                .map(author -> new AuthorResponse(author.getId(), author.getName()))
                .collect(Collectors.toList()));

        return response;
    }
}

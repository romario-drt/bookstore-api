package com.romario.bookstore_api.custom.converter;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.Enum.GenreType;
import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.entity.Genre;
import com.romario.bookstore_api.model.request.BookReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RepToBookConverter implements Converter<BookReq, Book> {
    @Override
    public Book convert(BookReq source) {
        Book b = new Book();
        Genre genre = new Genre();

        b.setTitle(source.getTitle());
        b.setIsbn(source.getIsbn());
        b.setPublishedDate(source.getPublishedDate());
        b.setQuantity(source.getQuantity());
        b.setPrice(source.getPrice());
        b.setImg(source.getImg());

        genre.setGenre(GenreType.valueOf(source.getGenre()));
        b.setGenre(genre);

        b.setCondition(BookConditionType.valueOf(source.getCondition()));

        b.setAuthors(source.getAuthors().stream().map(Author::new).collect(Collectors.toList()));

        return b;
    }
}

package com.romario.bookstore_api.custom.converter;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.request.BookReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RepToBookConverter implements Converter<BookReq, Book> {
    @Override
    public Book convert(BookReq source) {
        Book b = new Book();

        b.setTitle(source.getTitle());
        b.setIsbn(source.getIsbn());
        b.setPublishedDate(source.getPublishedDate());
        b.setQuantity(source.getQuantity());
        b.setPrice(source.getPrice());
        b.setImg(source.getImg());
        b.setCondition(BookConditionType.valueOf(source.getCondition()));

        return b;
    }
}

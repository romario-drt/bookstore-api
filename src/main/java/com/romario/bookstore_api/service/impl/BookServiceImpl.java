package com.romario.bookstore_api.service.impl;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.model.entity.Book;
import com.romario.bookstore_api.model.request.BookFilterReq;
import com.romario.bookstore_api.repository.BooksRepo;
import com.romario.bookstore_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.romario.bookstore_api.repository.specification.BookSpec.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BooksRepo booksRepo;

    @Override
    public Optional<Book> findByTitle(String title) {
        return booksRepo.findByTitle(title);
    }

    @Override
    public Book save(Book book) {
        return booksRepo.save(book);
    }

    @Override
    public List<Book> findBySpecification(BookFilterReq filters) {

        //If price is given ignore price range
        if (filters.getPrice() != null) {
            filters.setPriceStart(null);
            filters.setPriceEnd(null);
        }

        Specification<Book> base = Specification
                .where(titleLike("%" + filters.getTitle() + "%"))
                .and(filters.getCondition() == null ? null : conditionEquals(BookConditionType.valueOf(filters.getCondition())))
                .and(filters.getGenre() == null ? null : genreEquals(filters.getGenre()))
                .and(filters.getPrice() == null ? null : priceEquals(filters.getPrice()))
                .and((filters.getPriceStart() == null || filters.getPriceEnd() == null) ? null : priceBetween(filters.getPriceStart(), filters.getPriceEnd()))
                .and(filters.getPriceStart() == null ? null : priceGreaterThan(filters.getPriceStart()))
                .and(filters.getPriceEnd() == null ? null : priceLessThan(filters.getPriceEnd()))
                .and(filters.getIsbn() == null ? null : isbnEquals(filters.getIsbn()));

        return booksRepo.findAll(base);
    }
}

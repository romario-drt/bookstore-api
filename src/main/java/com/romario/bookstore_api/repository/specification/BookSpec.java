package com.romario.bookstore_api.repository.specification;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.model.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/**
 * class definitions for book specification.
 */
public abstract class BookSpec {

    //find a title like (?)
    public static Specification<Book> titleLike(String title) {
        return (root, query, cb) -> cb.like(cb.upper(root.get("title")), title.toUpperCase());
    }

    //condition should match exactly
    public static Specification<Book> conditionEquals(BookConditionType condition) {
        return (root, query, cb) -> cb.equal(root.get("condition"), condition);
    }

    public static Specification<Book> genreEquals(String genre) {
        return (root, q, cb) -> cb.equal(cb.upper(root.get("genre").get("genre")), genre.toUpperCase());
    }

    public static Specification<Book> isbnEquals(String isbn) {
        return (root, q, cb) -> cb.equal(root.get("isbn"), isbn);
    }

    public static Specification<Book> priceEquals(BigDecimal price) {
        return (root, query, cb) -> cb.equal(root.get("price"), price);
    }

    public static Specification<Book> priceBetween(BigDecimal start, BigDecimal end) {
        return (root, query, cb) -> cb.between(root.get("price"), start, end);
    }

    public static Specification<Book> priceGreaterThan(BigDecimal start) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), start);
    }

    public static Specification<Book> priceLessThan(BigDecimal end) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), end);
    }
}

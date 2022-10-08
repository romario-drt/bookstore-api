package com.romario.bookstore_api.model.response;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.model.entity.Author;
import com.romario.bookstore_api.model.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private String title;

    private BookConditionType condition;

    private String isbn;

    private LocalDate publishedDate;

    private String img;

    private BigDecimal price;

    private int quantity;

    private String genre;

    private List<AuthorResponse> authors;
}

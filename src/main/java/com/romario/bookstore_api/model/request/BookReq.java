package com.romario.bookstore_api.model.request;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.custom.validation.NotEmptyList;
import com.romario.bookstore_api.custom.validation.ValidEnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReq {

    @NotBlank(message = "{validation.title.required}")
    private String title;

    @NotNull(message = "{validation.condition.required}")
    @ValidEnumType(enumClass = BookConditionType.class, message = "{validation.condition.invalid}")
    private String condition;

    @ISBN(message = "{validation.isbn.invalid}")
    @NotBlank(message = "{validation.isbn.required}")
    private String isbn;

    @NotNull(message = "{validation.publishedDate.required}")
    @Past(message = "{validation.publishedDate.invalid}")
    private LocalDate publishedDate;

    @Min(value = 1, message = "{validation.price.min}")
    @Max(value = 1000, message = "{validation.price.max}")
    private BigDecimal price;

    @Min(value = 1, message = "{validation.quantity.min}")
    @Max(value = 99, message = "{validation.quantity.max}")
    private int quantity;

    @NotBlank(message = "{validation.genre.required}")
    public String genre;

    @NotEmptyList(message = "{validation.authors.required}")
    private List<@NotBlank(message = "{validation.authors.required}") String> authors;

    @NotBlank(message = "{validation.img.required}")
    @URL(message = "{validation.img.invalid}")
    private String img;

}

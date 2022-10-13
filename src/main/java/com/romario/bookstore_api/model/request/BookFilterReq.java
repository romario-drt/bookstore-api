package com.romario.bookstore_api.model.request;

import com.romario.bookstore_api.Enum.BookConditionType;
import com.romario.bookstore_api.custom.validation.ValidEnumType;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;

@Data
public class BookFilterReq {

    private String title;

    @ValidEnumType(enumClass = BookConditionType.class, message = "{validation.condition.invalid}")
    private String condition;

    @ISBN(message = "{validation.isbn.invalid}")
    private String isbn;

    private BigDecimal price;
    private BigDecimal priceStart;
    private BigDecimal priceEnd;

    public String genre;

}

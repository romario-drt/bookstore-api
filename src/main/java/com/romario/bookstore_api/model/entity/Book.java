package com.romario.bookstore_api.model.entity;

import com.romario.bookstore_api.Enum.BookConditionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends AbstractModel {

    @Column(unique = true)
    private String title;

    @Enumerated(EnumType.STRING)
    private BookConditionType condition;

    @ISBN
    private String isbn;

    private String publishedDate;

    @Column(scale = 2, precision = 20)
    private BigDecimal price;

    private int quantity;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;
}

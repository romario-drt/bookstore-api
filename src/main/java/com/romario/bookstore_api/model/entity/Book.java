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

    private String isbn;

    private String publishedDate;

    @Column(length = 500, nullable = false)
    private String img;

    @Column(scale = 2, precision = 20)
    private BigDecimal price;

    private int quantity;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, optional = false)
    @JoinColumn
    private Genre genre;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Author> authors;
}

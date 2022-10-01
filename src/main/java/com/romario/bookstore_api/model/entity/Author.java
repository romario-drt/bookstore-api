package com.romario.bookstore_api.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends AbstractModel {

    private String firstName;
    private String middleName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}

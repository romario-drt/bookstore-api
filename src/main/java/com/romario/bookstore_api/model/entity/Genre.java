package com.romario.bookstore_api.model.entity;

import com.romario.bookstore_api.Enum.GenreType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends AbstractModel {

    @Enumerated(EnumType.STRING)
    public GenreType genre;

    @OneToMany(mappedBy = "genre")
    private List<Book> books;
}

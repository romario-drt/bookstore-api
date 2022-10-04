package com.romario.bookstore_api.model.entity;

import com.romario.bookstore_api.Enum.GenreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends AbstractModel {

    @Enumerated(EnumType.STRING)
    public GenreType genre;

    @OneToMany(mappedBy = "genre")
    private List<Book> books;
}

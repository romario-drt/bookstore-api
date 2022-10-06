package com.romario.bookstore_api.model.entity;

import com.romario.bookstore_api.Enum.GenreType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends AbstractModel {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    public GenreType genre;
}

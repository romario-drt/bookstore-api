package com.romario.bookstore_api.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends AbstractModel {

    @Column(unique = true)
    public String genre;
}

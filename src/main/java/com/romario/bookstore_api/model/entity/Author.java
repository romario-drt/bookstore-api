package com.romario.bookstore_api.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author extends AbstractModel {

    @Column(unique = true)
    private String name;

}

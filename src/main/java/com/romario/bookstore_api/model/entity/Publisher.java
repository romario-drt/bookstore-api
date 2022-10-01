package com.romario.bookstore_api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends AbstractModel {

    public String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}

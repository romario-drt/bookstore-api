package com.romario.bookstore_api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AbstractModel {

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;


    private String password;
    private boolean isAdmin;

    @OneToMany(mappedBy = "customer")
    private List<BookOrder> orders;
}

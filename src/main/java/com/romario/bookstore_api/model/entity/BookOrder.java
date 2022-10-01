package com.romario.bookstore_api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookOrder extends AbstractModel {

    private String reference;
    private BigDecimal total;
    private String status;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "bookOrder")
    private List<OrderLine> orderLineList;
}

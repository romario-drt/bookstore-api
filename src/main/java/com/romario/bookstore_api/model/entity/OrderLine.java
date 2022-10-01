package com.romario.bookstore_api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine extends AbstractModel {

    private int quantity;
    private BigDecimal price;

    @ManyToOne
    private BookOrder bookOrder;
}

package com.romario.bookstore_api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private int version;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;

    @PrePersist
    public void prepareCreationDate(){
        if (this.creationDate == null){
            this.creationDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void prepareUpdateDate(){
        this.updateDate = LocalDateTime.now();
    }

}

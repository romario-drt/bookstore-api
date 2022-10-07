package com.romario.bookstore_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreReq {

    @NotBlank(message = "{validation.genre.required}")
    public String genre;
}

package com.romario.bookstore_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorReq {

    @NotBlank(message = "{validation.author.required}")
    public String name;
}

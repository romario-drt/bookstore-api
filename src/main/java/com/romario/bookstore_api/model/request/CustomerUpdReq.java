package com.romario.bookstore_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdReq {

    @NotEmpty(message = "{validation.firstname.required}")
    private String firstname;

    @NotEmpty(message = "{validation.lastname.required}")
    private String lastname;
}

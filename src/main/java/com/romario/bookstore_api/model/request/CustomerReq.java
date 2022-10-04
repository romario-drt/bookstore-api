package com.romario.bookstore_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReq {

    @NotEmpty(message = "{validation.firstname.required}")
    private String firstname;

    @NotEmpty(message = "{validation.lastname.required}")
    private String lastname;

    @NotEmpty(message = "{validation.email.required}")
    @Email(message = "{validation.email.required}")
    private String email;

    @NotEmpty(message = "{validation.password.required}")
    private String password;

    @NotEmpty(message = "{validation.password2.required}")
    private String password2;

    private boolean isAdmin;

}

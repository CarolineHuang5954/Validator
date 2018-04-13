package com.caroline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User<T> {

    private String username;

    @NotBlank(message = "{user.name.empty}")
    private String password;

    @Valid
    private T childUser;

}

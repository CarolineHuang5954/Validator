package com.caroline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildUser {

    @NotBlank(message="{childuser.name.empty}")
    private String childUsername;

    private String childPassword;

}

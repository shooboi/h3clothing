package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
//    @Email
    private String email;
//    @Pattern(regexp = "a-z")
    private String password;
}

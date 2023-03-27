package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min=8, max=16)
    private String password;
}

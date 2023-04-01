package net.aptech.h3clothing.dto;

import lombok.*;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Email
    private String email;
    private String password;
}

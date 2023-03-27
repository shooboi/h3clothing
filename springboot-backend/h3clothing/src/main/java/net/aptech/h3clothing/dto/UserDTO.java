package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserDTO {

    private String email;
    private String password;
}

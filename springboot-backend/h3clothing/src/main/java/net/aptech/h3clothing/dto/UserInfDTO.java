package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfDTO {
    @NotBlank
    @Pattern(regexp = "([A-Za-z]+( [A-Za-z]+)+)", message = "Your name must only contains upper and lowercase letters")
    private String fullName;
    @NotBlank
    //@Digits(fraction = 0, integer = 10)
    @Pattern(regexp = "\\d{10}$", message = "Phone numbers must only contain digits")
    private String phoneNumber;
    @NotBlank
    private String address;
    @NotBlank
    private boolean isDeleted;
    @NotBlank
    private Date dob;
}

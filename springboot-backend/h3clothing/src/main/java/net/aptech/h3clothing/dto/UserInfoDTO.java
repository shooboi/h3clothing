package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDTO {
    @NotBlank
    @Pattern(regexp = "([A-Za-z]+( [A-Za-z]+)+)")
    private String fullName;

    @Pattern(regexp = "\\d{10}$", message = "Phone numbers must only contain digits")
    private String phoneNumber;

    private String address;

    private Date dob;
}

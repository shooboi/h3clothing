package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDTO {
    @NotBlank
    @Pattern(regexp = "([A-Za-z]+( [A-Za-z]+)+)")
    private String fullName;

    @Size(max=10)
    @Pattern(regexp = "\\d")
    private String phoneNumber;

    private String address;

    private Date dob;
}

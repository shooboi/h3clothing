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
public class BlogUserDTO extends UserInfDTO{
    @NotBlank
    private int Id;

    public BlogUserDTO(int id, @NotBlank @Pattern(regexp = "([A-Za-z]+( [A-Za-z]+)+)", message = "Your name must only contains upper and lowercase letters") String fullName, @NotBlank @Pattern(regexp = "\\d{10}$", message = "Phone numbers must only contain digits") String phoneNumber, @NotBlank String address, @NotBlank boolean isDeleted, @NotBlank Date dob) {
        super(fullName, phoneNumber, address, isDeleted, dob);
        Id = id;
    }
}

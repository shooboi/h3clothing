package net.aptech.h3clothing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

  private int id;
  private String email;
  private String password;

  public UserDTO(String email, String password) {
    this.email = email;
    this.password = password;
  }
}

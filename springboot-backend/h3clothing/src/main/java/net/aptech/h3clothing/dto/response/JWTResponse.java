package net.aptech.h3clothing.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import net.aptech.h3clothing.entity.Role;

@Getter
@Setter
public class JWTResponse {

  private String token;

  private String type = "Bearer";

//        private Long id;

  private String email;

  private List<String> roles;

  public JWTResponse(String token, String email, List<String> roles) {
    this.token = token;
    this.email = email;
    this.roles = roles;
  }

}

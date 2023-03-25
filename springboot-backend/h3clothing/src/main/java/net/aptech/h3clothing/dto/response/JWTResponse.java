package net.aptech.h3clothing.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JWTResponse {
        private String token;

        private String type = "Bearer";

//        private Long id;

        private String email;

//        private List<String> roles;

        public JWTResponse(String token, String email) {
            this.token = token;
            this.email = email;
        }

}

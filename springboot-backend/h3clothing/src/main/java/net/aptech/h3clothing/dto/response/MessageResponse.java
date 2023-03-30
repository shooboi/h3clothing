package net.aptech.h3clothing.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
    private String title;
    private String message;

    public MessageResponse(String title, String message) {
        this.title = title;
        this.message = message;
    }
}

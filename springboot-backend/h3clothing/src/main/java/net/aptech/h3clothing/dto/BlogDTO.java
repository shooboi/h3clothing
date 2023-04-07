package net.aptech.h3clothing.dto;

import lombok.*;
import net.aptech.h3clothing.entity.User_Info;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    @NotBlank
    private String title;

    private String description;

    private UserInfDTO user;

    private boolean isPublished;

    private Instant createdAt;

    private Instant updatedAt;

    public LocalDateTime getCreatedLocalDateTime(){
        return LocalDateTime.ofInstant(getCreatedAt(), ZoneId.systemDefault());
    }

    public LocalDateTime getUpdatedLocalDateTime(){
        return LocalDateTime.ofInstant(getUpdatedAt(), ZoneId.systemDefault());
    }
}

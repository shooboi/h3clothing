package net.aptech.h3clothing.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private int id;
    @NotBlank
    private String title;
    private int parentId;

    public CategoryDTO(String title, int parentId) {
        this.title = title;
        this.parentId = parentId;
    }
}

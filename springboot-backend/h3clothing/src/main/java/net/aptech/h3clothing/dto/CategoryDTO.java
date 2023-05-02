package net.aptech.h3clothing.dto;

import java.util.List;
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

    private List<CategoryDTO> child;

    public CategoryDTO(int id, String title, int parentId) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
    }

    public CategoryDTO(int id, String title, int parentId, List<CategoryDTO> child) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.child = child;
    }
}

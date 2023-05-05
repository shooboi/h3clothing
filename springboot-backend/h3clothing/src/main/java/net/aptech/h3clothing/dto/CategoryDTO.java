package net.aptech.h3clothing.dto;

import java.util.List;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

  private int id;
  private String title;
  private int parentId;

  private List<CategoryDTO> child;

}

package net.aptech.h3clothing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {

  private int id;
  private String title;
  private int parentId;

  private List<CategoryDTO> child;

}

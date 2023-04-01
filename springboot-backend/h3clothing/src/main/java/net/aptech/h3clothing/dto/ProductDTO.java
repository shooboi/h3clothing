package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    @NotBlank
    private String name;

    private String description;

    @Min(value=0)
    @Max(value=Integer.MAX_VALUE)
    private double price;

    private CategoryDTO category;
}

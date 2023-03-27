package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    private double price;
}

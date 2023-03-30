package net.aptech.h3clothing.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Table(name = "size")
@Entity
@Data
public class Size extends Base{
    @Column(name = "name")
    private String name;

    @Min(value = 0)
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Size() {
    }

    public Size(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}

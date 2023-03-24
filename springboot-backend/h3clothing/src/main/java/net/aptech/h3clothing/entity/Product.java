package net.aptech.h3clothing.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "products")
@Entity
public class Product extends Base {
    @Column(name ="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;


}

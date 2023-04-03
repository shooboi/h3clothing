package net.aptech.h3clothing.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "products")
@Entity
public class Product extends Base {
    @Column(name ="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(String name, String description, double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}

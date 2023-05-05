package net.aptech.h3clothing.entity;

import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Thumbnail_Image> imageList;

    public Product() {
    }

    public Product(String name, String description, double price, Category category, List<Thumbnail_Image> imageList) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageList = imageList;
    }
}

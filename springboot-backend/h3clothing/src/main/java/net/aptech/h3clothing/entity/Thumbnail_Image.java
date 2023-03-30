package net.aptech.h3clothing.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "thumbnail_image")
@Entity
@Data
public class Thumbnail_Image extends Base {
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Thumbnail_Image() {
    }

    public Thumbnail_Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

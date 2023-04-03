package net.aptech.h3clothing.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "thumbnail_image")
@Entity
@Data
public class Thumbnail_Image extends Base {
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id")
    private Product product;

    public Thumbnail_Image() {
    }

    public Thumbnail_Image(String imageUrl, Product product) {
        this.imageUrl = imageUrl;
        this.product = product;
    }

    @Transient
    public String getPhotosImagePath() {
        if (imageUrl == null) return null;
        return "/products-photos/" + this.product.getName() + "/" + imageUrl;
    }
}

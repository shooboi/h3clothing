package net.aptech.h3clothing.entity;

import javax.persistence.*;

@Table(name = "thumbnail_image")
@Entity
public class Thumbnail_Image extends Base {
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

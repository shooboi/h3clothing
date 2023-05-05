package net.aptech.h3clothing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Table(name = "thumbnail_image")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Thumbnail_Image extends Base {

  @Column(name = "image_url")
  private String imageUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

}

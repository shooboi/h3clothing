package net.aptech.h3clothing.entity;

import javax.persistence.*;
import lombok.Data;

@Table(name = "order_details")
@Entity
@Data
public class Order_Detail {
    @EmbeddedId
    private OrderDetailKey id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;


}

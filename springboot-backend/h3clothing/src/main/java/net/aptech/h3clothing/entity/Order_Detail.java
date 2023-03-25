package net.aptech.h3clothing.entity;

import javax.persistence.*;

@Table(name = "order_details")
@Entity
public class Order_Detail {
    @EmbeddedId
    private OrderDetailKey id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;


}

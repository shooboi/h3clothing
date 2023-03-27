package net.aptech.h3clothing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "orders")
@Entity
public class Order extends  Base {
    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "payment_method")
    private String paymentMethod;


    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "status")
    private Status status;

}

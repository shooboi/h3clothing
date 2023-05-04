package net.aptech.h3clothing.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "orders")
@Entity
@Data
public class Order extends  Base {
    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    public Order() {
    }

    public Order(Timestamp orderDate, double totalAmount, String paymentMethod, String deliveryAddress, Status status) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
    }
}

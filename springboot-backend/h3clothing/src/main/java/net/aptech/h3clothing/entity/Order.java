package net.aptech.h3clothing.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@Data
public class Order extends Base {

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public Order() {
  }

}

package net.aptech.h3clothing.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

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

  @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Order_Detail> orderDetails;

  public Order() {
  }

}

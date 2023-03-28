package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.aptech.h3clothing.entity.Status;

import javax.persistence.Column;
import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Timestamp orderDate;

    private double totalAmount;

    private String paymentMethod;

    private String deliveryAddress;

    private Status status;
}

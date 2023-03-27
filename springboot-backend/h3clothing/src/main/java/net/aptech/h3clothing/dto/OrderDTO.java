package net.aptech.h3clothing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.aptech.h3clothing.entity.Status;

import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {
    private Timestamp orderDate;
    @Min(value=0)
    private double totalAmount;

    private String paymentMethod;

    private String deliveryAddress;

    private Status status;
}

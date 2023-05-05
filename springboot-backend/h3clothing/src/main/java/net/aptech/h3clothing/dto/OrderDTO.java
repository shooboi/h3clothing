package net.aptech.h3clothing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.aptech.h3clothing.entity.Status;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    private UserDTO user;
    private Timestamp orderDate;

    private double totalAmount;

    private String paymentMethod;

    private String deliveryAddress;

    private Status status;

    List<OrderDetailDTO> orderDetails;
}

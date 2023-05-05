package net.aptech.h3clothing.service.mapper;

import java.util.List;
import net.aptech.h3clothing.dto.OrderDTO;
import net.aptech.h3clothing.dto.OrderDetailDTO;
import net.aptech.h3clothing.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {

  OrderDTO getOrderDTOFromOrder(Order order);

  Order getOrderFromOrderDTO(OrderDTO orderDTO);

  void updateOrder(OrderDTO orderDTO, @MappingTarget Order order);


}

package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.OrderDetailDTO;
import net.aptech.h3clothing.entity.Order_Detail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderDetailMapper {
  @Mapping(source = "id.order", target = "order")
  @Mapping(source = "id.product", target = "product")
  OrderDetailDTO getOrderDetailDTOFromOrderDetail(Order_Detail orderDetail);

  @Mapping(source = "order", target = "id.order")
  @Mapping(source = "product", target = "id.product")
  Order_Detail getOrderDetailFromOrderDetailDTO(OrderDetailDTO orderDetailDTO);

  void updateOrderDetail(OrderDetailDTO orderDetailDTO, @MappingTarget Order_Detail orderDetail);


}

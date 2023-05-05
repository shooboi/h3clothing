package net.aptech.h3clothing.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.OrderDetailDTO;
import net.aptech.h3clothing.entity.Order_Detail;
import net.aptech.h3clothing.repository.OrderDetailRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements GenericService<OrderDetailDTO> {

  final OrderDetailRepository repository;

  final OrderDetailMapper orderDetailMapper;

  @Override
  public List<OrderDetailDTO> getAll() {
    return repository.findAll().stream().map(orderDetailMapper::getOrderDetailDTOFromOrderDetail)
        .collect(
            Collectors.toList());
  }

  @Override
  public OrderDetailDTO add(OrderDetailDTO orderDetailDTO) {
    Order_Detail orderDetail = repository.save(
        orderDetailMapper.getOrderDetailFromOrderDetailDTO(orderDetailDTO));

    return orderDetailMapper.getOrderDetailDTOFromOrderDetail(orderDetail);
  }

  @Override
  public OrderDetailDTO update(int id, OrderDetailDTO orderDetailDTO) {
    Order_Detail orderDetail = repository.getById(id);
    orderDetailMapper.updateOrderDetail(orderDetailDTO, orderDetail);
    repository.save(orderDetail);
    return orderDetailMapper.getOrderDetailDTOFromOrderDetail(orderDetail);
  }

  @Override
  public Optional<OrderDetailDTO> getById(int id) {
    Order_Detail orderDetail = repository.getById(id);
    return Optional.ofNullable(orderDetailMapper.getOrderDetailDTOFromOrderDetail(orderDetail));
  }

  @Override
  public void remove(int id) {
    repository.deleteById(id);
  }
}

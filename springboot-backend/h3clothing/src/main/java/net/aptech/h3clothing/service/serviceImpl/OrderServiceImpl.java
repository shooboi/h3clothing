package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.OrderDTO;
import net.aptech.h3clothing.entity.Order;
import net.aptech.h3clothing.repository.OrderRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements GenericService<OrderDTO> {

  final OrderRepository repository;

  final OrderMapper orderMapper;

  @Override
  public List<OrderDTO> getAll() {
    return repository.findAll().stream().map(orderMapper::getOrderDTOFromOrder).collect(
        Collectors.toList());
  }

  @Override
  public OrderDTO add(OrderDTO orderDTO) {
    Order order = repository.save(orderMapper.getOrderFromOrderDTO(orderDTO));
    return orderMapper.getOrderDTOFromOrder(order);
  }

  @Override
  public OrderDTO update(int id, OrderDTO orderDTO) {
    Order order = repository.getById(id);
    orderMapper.updateOrder(orderDTO, order);
    repository.save(order);
    return orderMapper.getOrderDTOFromOrder(order);
  }


  @Override
  public Optional<OrderDTO> getById(int id) {
    return Optional.ofNullable(orderMapper.getOrderDTOFromOrder(repository.getById(id)));
  }

  @Override
  public void remove(int id) {
    repository.deleteById(id);
  }
}

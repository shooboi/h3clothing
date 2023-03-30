package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.OrderDTO;
import net.aptech.h3clothing.entity.Order;
import net.aptech.h3clothing.repository.OrderRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class OrderServiceImpl implements GenericService<OrderDTO> {

    @Autowired
    OrderRepository repository;

    @Autowired
    Utility utility;
    @Override
    public List<OrderDTO> getAll() {
        return utility.convertOrderDTOFromOrders(repository.findAll());
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = repository.save(utility.convertOrderFromOrderDTO(orderDTO));
        return new OrderDTO(order.getOrderDate(),order.getTotalAmount(),order.getPaymentMethod(),order.getDeliveryAddress(),order.getStatus());
    }

    @Override
    public Optional<OrderDTO> getById(int id) {
        return Optional.of(utility.convertOrderDTOFromOrder(repository.getById(id)));
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}

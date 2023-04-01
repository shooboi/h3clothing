package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.dto.OrderDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    final GenericService<OrderDTO> service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRole(@Valid @RequestBody OrderDTO orderDTO) {
        service.save(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody OrderDTO orderDTO) {
        OrderDTO find = extractOrderDTOFromField(id, orderDTO);
        return ResponseEntity.ok(find);
    }

    public OrderDTO extractOrderDTOFromField(Integer id, OrderDTO orderDTO) {
        OrderDTO dto = service.getById(id).get();
        dto.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        dto.setStatus(orderDTO.getStatus());
        dto.setDeliveryAddress(orderDTO.getDeliveryAddress());
        dto.setTotalAmount(orderDTO.getTotalAmount());
        dto.setPaymentMethod(orderDTO.getPaymentMethod());
        service.save(dto);
        return dto;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        OrderDTO dto = service.getById(id).get();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.remove(id);
        return ResponseEntity.ok("Deleted");
    }
}

package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.OrderDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.OrderDetailServiceImpl;
import net.aptech.h3clothing.service.serviceImpl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  final GenericService<OrderDTO> dtoGenericService;

  public OrderController(OrderServiceImpl dtoGenericService) {
    this.dtoGenericService = dtoGenericService;
  }

  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(dtoGenericService.getAll());
  }

  @PostMapping("/add")
  public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
    return ResponseEntity.ok(dtoGenericService.add(orderDTO));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody OrderDTO orderDTO) {
    return ResponseEntity.ok(dtoGenericService.update(id, orderDTO));
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable("id") int id) {
    dtoGenericService.remove(id);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<?> get(@PathVariable("id") int id) {
    return ResponseEntity.ok(dtoGenericService.getById(id));
  }
}

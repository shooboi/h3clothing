package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.OrderDetailDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.OrderDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailController {

  final GenericService<OrderDetailDTO> orderDetailControllerGenericService;

  public OrderDetailController(
      OrderDetailServiceImpl orderDetailControllerGenericService) {
    this.orderDetailControllerGenericService = orderDetailControllerGenericService;
  }

  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(orderDetailControllerGenericService.getAll());
  }

  @PostMapping("/add")
  public ResponseEntity addOrder(@RequestBody OrderDetailDTO orderDetailDTO){
    return ResponseEntity.ok(orderDetailControllerGenericService.add(orderDetailDTO));
  }


}

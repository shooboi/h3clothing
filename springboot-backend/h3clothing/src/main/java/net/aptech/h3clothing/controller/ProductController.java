package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.entity.Product;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    final GenericService<ProductDTO> service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO){
        service.save(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }


}

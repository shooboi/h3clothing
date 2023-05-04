package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.entity.Product;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.ProductService;
import net.aptech.h3clothing.service.serviceImpl.ProductServiceImpl;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  ProductService productService;
  final GenericService<ProductDTO> service;

  @Autowired
  Utility utility;

  public ProductController(ProductServiceImpl service) {
    this.service = service;
  }

  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping("/add")
  public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO) {
    service.save(productDTO);
    return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
  }

  @GetMapping("/page/{index}")
  public List<ProductDTO> pagination(@PathVariable("index") Integer index,
      @RequestBody ProductDTO dto) {
    return productService.findAllByPage(dto, index);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id,
      @RequestBody ProductDTO productDTO) {
    ProductDTO find = extractProductDTOFromField(id, productDTO);
    return ResponseEntity.ok(find);
  }

  public ProductDTO extractProductDTOFromField(Integer id, ProductDTO productDTO) {
    ProductDTO dto = service.getById(id).get();
    dto.setName(productDTO.getName());
    dto.setPrice(productDTO.getPrice());
    dto.setDescription(productDTO.getDescription());
    dto.setCategory(productDTO.getCategory());
    service.save(dto);
    return dto;
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<?> get(@PathVariable("id") Integer id) {
    ProductDTO dto = service.getById(id).get();
    return ResponseEntity.ok(dto);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    service.remove(id);
    return ResponseEntity.ok("Deleted");
  }


}

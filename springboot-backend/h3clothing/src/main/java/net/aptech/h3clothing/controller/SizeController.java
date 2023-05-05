package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.dto.SizeDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.SizeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/size")
public class SizeController {

  final GenericService<SizeDTO> service;

  public SizeController(SizeServiceImpl service) {
    this.service = service;
  }


  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping("/add")
  public ResponseEntity<?> addRole(@Valid @RequestBody SizeDTO sizeDTO) {
    service.add(sizeDTO);
    return new ResponseEntity<>(sizeDTO, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody SizeDTO sizeDTO) {
    SizeDTO find = service.update(id, sizeDTO);
    return ResponseEntity.ok(find);
  }


  @GetMapping("/get/{id}")
  public ResponseEntity<?> get(@PathVariable("id") Integer id) {
    SizeDTO dto = service.getById(id).get();
    return ResponseEntity.ok(dto);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    service.remove(id);
    return ResponseEntity.ok("Deleted");
  }
}

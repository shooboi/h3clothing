package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.dto.RoleDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.RoleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

  final GenericService<RoleDTO> service;

  public RoleController(RoleServiceImpl service) {
    this.service = service;
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/add")
  public ResponseEntity<?> addRole(@Valid @RequestBody RoleDTO roleDTO) {
    service.add(roleDTO);
    return new ResponseEntity<>(roleDTO, HttpStatus.CREATED);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody RoleDTO roleDTO) {
    RoleDTO find = service.update(id, roleDTO);
    return ResponseEntity.ok(find);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/get/{id}")
  public ResponseEntity<?> get(@PathVariable("id") Integer id) {
    RoleDTO dto = service.getById(id).get();
    return ResponseEntity.ok(dto);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    service.remove(id);
    return ResponseEntity.ok("Deleted");
  }
}

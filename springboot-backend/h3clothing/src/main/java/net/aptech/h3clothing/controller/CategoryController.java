package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.dto.RoleDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    final GenericService<CategoryDTO> service;

    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRole(@Valid @RequestBody CategoryDTO categoryDTO) {
        service.save(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO find = extractCategoryDTOFromField(id, categoryDTO);
        return ResponseEntity.ok(find);
    }

    public CategoryDTO extractCategoryDTOFromField(Integer id, CategoryDTO categoryDTO) {
        CategoryDTO dto = service.getById(id).get();
        dto.setTitle(categoryDTO.getTitle());
        dto.setParentId(categoryDTO.getParentId());
        service.save(dto);
        return dto;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        CategoryDTO dto = service.getById(id).get();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.remove(id);
        return ResponseEntity.ok("Deleted");
    }
}

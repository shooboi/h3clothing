package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.service.CategoryService;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.CategoryServiceImpl;
import net.aptech.h3clothing.util.CategoryTree;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

  final CategoryTree categoryTree;
  final GenericService<CategoryDTO> service;

  final CategoryService categoryService;

  public CategoryController(CategoryTree categoryTree, CategoryServiceImpl service,
      CategoryService categoryService) {
    this.categoryTree = categoryTree;
    this.service = service;
    this.categoryService = categoryService;
  }


  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(categoryTree.displayCategoryListTree());
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/add")
  public ResponseEntity<?> addRole(@Valid @RequestBody CategoryDTO categoryDTO) {
    service.add(categoryDTO);
    return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id,
      @RequestBody CategoryDTO categoryDTO) {
    CategoryDTO find = service.update(id, categoryDTO);
    return ResponseEntity.ok(find);
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/get/{id}")
  public ResponseEntity<?> get(@PathVariable("id") Integer id) {
    CategoryDTO dto = service.getById(id).get();
    return ResponseEntity.ok(dto);
  }
  @PreAuthorize("hasAuthority('ADMIN')")
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    service.remove(id);
    return ResponseEntity.ok("Deleted");
  }
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/root")
  public ResponseEntity<?> getAllParent() {
    return ResponseEntity.ok(categoryService.getAllParentRoot());
  }
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/getChild/{id}")
  public ResponseEntity<?> getChildsFromParentId(@PathVariable("id") int id) {
    return ResponseEntity.ok(categoryTree.getAllChildCategories(id));
  }

}

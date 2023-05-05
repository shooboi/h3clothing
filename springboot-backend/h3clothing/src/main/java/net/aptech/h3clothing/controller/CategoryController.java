package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.service.CategoryService;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.CategoryServiceImpl;
import net.aptech.h3clothing.util.CategoryTree;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
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


  @PostMapping("/add")
  public ResponseEntity<?> addRole(@Valid @RequestBody CategoryDTO categoryDTO) {
    service.add(categoryDTO);
    return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id,
      @RequestBody CategoryDTO categoryDTO) {
    CategoryDTO find = service.update(id, categoryDTO);
    return ResponseEntity.ok(find);
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

  @GetMapping("/root")
  public ResponseEntity<?> getAllParent() {
    return ResponseEntity.ok(categoryService.getAllParentRoot());
  }

  @GetMapping("/getChild/{id}")
  public ResponseEntity<?> getChildsFromParentId(@PathVariable("id") int id) {
    return ResponseEntity.ok(categoryTree.getAllChildCategories(id));
  }

}

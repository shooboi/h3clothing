package net.aptech.h3clothing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import net.aptech.h3clothing.dto.ProductDTO;
//import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.entity.Thumbnail_Image;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.ProductService;
import net.aptech.h3clothing.service.serviceImpl.ProductServiceImpl;
import net.aptech.h3clothing.util.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

  final ProductService productService;
  final GenericService<ProductDTO> service;

  final ObjectMapper objectMapper;


  public ProductController(ProductService productService, ProductServiceImpl service,
      ObjectMapper objectMapper) {
    this.productService = productService;
    this.service = service;
    this.objectMapper = objectMapper;
  }

  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(service.getAll());
  }
//
//  @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
//        MediaType.APPLICATION_JSON_VALUE})
  @PostMapping(value = "/add",consumes = {"multipart/form-data"})
//  @ResponseBody
  public ResponseEntity<?> addProduct(@Valid @RequestPart("product") String productDTO,
      @RequestPart("file") MultipartFile[] file) throws IOException {
    ProductDTO dto = objectMapper.readValue(productDTO, ProductDTO.class);
    setOrigin(file, dto);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);
  }


  @GetMapping("/page/{index}")
  public List<ProductDTO> pagination(@PathVariable("index") Integer index,
      @RequestBody ProductDTO dto) {
    return productService.findAllByPage(dto, index);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id,
      @RequestBody ProductDTO productDTO) {
    ProductDTO find = service.update(id, productDTO);
    return ResponseEntity.ok(find);
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


  public void setOrigin(MultipartFile[] multipartFile, ProductDTO dto) throws IOException {
    List<ThumbnailDTO> files = new ArrayList<>();
    if (multipartFile.length > 0) {
      for (MultipartFile file : multipartFile) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        files.add(new ThumbnailDTO(fileName));
        String uploadDir = "products-photos/" + dto.getName();
        Utility.saveFile(uploadDir, fileName, file);
      }
      dto.setImageList(files);
      service.add(dto);
    }
  }


  }


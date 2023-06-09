package net.aptech.h3clothing.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.ProductService;
import net.aptech.h3clothing.service.serviceImpl.ProductServiceImpl;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  ProductService productService;
  final GenericService<ProductDTO> service;

  @Autowired
  Utility utility;

  @Autowired
  ObjectMapper objectMapper;


  public ProductController(ProductServiceImpl service) {
    this.service = service;
  }

  @GetMapping("/list")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
      MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<?> addProduct(@Valid @RequestPart("product") String productDTO,
      @RequestPart("file") MultipartFile[] file) throws IOException {
    ProductDTO dto = objectMapper.readValue(productDTO, ProductDTO.class);
    setOrigin(file, dto);
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


  public void setOrigin(MultipartFile[] multipartFile, ProductDTO dto) throws IOException {
    List<ThumbnailDTO> files = new ArrayList<>();
    if (multipartFile.length > 0) {
      for (MultipartFile file : multipartFile) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        service.save(dto);
//        System.out.println("ProductName " + dto.getProduct().getName());
//        String uploadDir = "products-photos/" + dto.getProduct().getName();
        files.add(new ThumbnailDTO(fileName));
        String uploadDir = "products-photos/" + dto.getName();
        Utility.saveFile(uploadDir, fileName, file);
      }
        dto.setImageUrl(files);
        service.save(dto);


    }


  }
}

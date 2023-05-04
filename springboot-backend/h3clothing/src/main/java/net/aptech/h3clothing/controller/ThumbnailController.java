package net.aptech.h3clothing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.ThumbnailServiceImpl;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/thumbnail")
public class ThumbnailController {
    final GenericService<ThumbnailDTO> service;
    @Autowired
    ObjectMapper objectMapper;


    public ThumbnailController(ThumbnailServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

//    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<?> addThumbnail(@RequestPart("file") MultipartFile[] file,  @RequestPart("product") String productDTO) throws IOException {
//            ProductDTO dto = objectMapper.readValue(productDTO, ProductDTO.class);
//            ThumbnailDTO thumbnailDTO = new ThumbnailDTO();
//            thumbnailDTO.setProduct(dto);
//            setOrigin(file, thumbnailDTO);
//            return new ResponseEntity<>(thumbnailDTO, HttpStatus.CREATED);
//    }

//    public void setOrigin(MultipartFile[] multipartFile, ThumbnailDTO dto) throws IOException {
//        if(multipartFile.length > 0){
//            for(MultipartFile file : multipartFile){
//                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//                dto.setImageUrl(fileName);
//                service.save(dto);
//                System.out.println("ProductName " + dto.getProduct().getName());
//                String uploadDir = "products-photos/" + dto.getProduct().getName();
//                Utility.saveFile(uploadDir, fileName, file);
//            }
//
//        }
//
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ThumbnailDTO thumbnailDTO) {
        ThumbnailDTO find = extractThumbnailDTOFromField(id, thumbnailDTO);
        return ResponseEntity.ok(find);
    }

    public ThumbnailDTO extractThumbnailDTOFromField(Integer id, ThumbnailDTO thumbnailDTO) {
        ThumbnailDTO dto = service.getById(id).get();
        dto.setImageUrl(thumbnailDTO.getImageUrl());
        service.save(dto);
        return dto;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        ThumbnailDTO dto = service.getById(id).get();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.remove(id);
        return ResponseEntity.ok("Deleted");
    }


}

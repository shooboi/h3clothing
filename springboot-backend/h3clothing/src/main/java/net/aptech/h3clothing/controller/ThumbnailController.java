package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.ThumbnailServiceImpl;
import net.aptech.h3clothing.util.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/thumbnail")
public class ThumbnailController {
    final GenericService<ThumbnailDTO> service;

    public ThumbnailController(ThumbnailServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addThumbnail(@Valid @RequestBody ThumbnailDTO thumbnailDTO, @RequestParam("images") MultipartFile multipartFile) throws IOException {
        setOrigin(multipartFile,thumbnailDTO);
        return new ResponseEntity<>(thumbnailDTO, HttpStatus.CREATED);
    }

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

    public void setOrigin(MultipartFile multipartFile, ThumbnailDTO dto) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        dto.setImageUrl(fileName);
        service.save(dto);
        String uploadDir = "products-photos/" + dto.getProductDTO().getName();
        Utility.saveFile(uploadDir, fileName, multipartFile);
    }
}

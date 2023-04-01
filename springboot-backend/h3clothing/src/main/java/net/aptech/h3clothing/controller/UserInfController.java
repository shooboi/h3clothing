package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.UserInfServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/userInf")
public class UserInfController {
    final GenericService<UserInfDTO> service;

    public UserInfController(UserInfServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRole(@Valid @RequestBody UserInfDTO userInfDTO) {
        service.save(userInfDTO);
        return new ResponseEntity<>(userInfDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody UserInfDTO userInfDTO) {
        UserInfDTO find = extractUserInfDTOFromField(id, userInfDTO);
        return ResponseEntity.ok(find);
    }

    public UserInfDTO extractUserInfDTOFromField(Integer id, UserInfDTO userInfDTO) {
        UserInfDTO dto = service.getById(id).get();
        dto.setAddress(userInfDTO.getAddress());
        dto.setDob(userInfDTO.getDob());
        dto.setFullName(userInfDTO.getFullName());
        dto.setDeleted(userInfDTO.isDeleted());
        dto.setPhoneNumber(userInfDTO.getPhoneNumber());
        service.save(dto);
        return dto;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        UserInfDTO dto = service.getById(id).get();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.remove(id);
        return ResponseEntity.ok("Deleted");
    }
}

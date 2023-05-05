package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.dto.response.MessageResponse;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final GenericService<UserDTO> userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO user){
        try{
            userService.add(user);
            return ResponseEntity.ok(new MessageResponse("Created !",user.getEmail()));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponse("Error !", "Illegal Argument"));
        }

    }
}

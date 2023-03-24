package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.LoginDTO;
import net.aptech.h3clothing.dto.response.JWTResponse;
import net.aptech.h3clothing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    LoginService service;
    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody LoginDTO loginDTO){
        try{
            JWTResponse response = service.login(loginDTO);
            return ResponseEntity.ok(response);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Login Failed !");
        }

    }
    @GetMapping("/ok")
    public String ok(){
        return "OK";
    }
}

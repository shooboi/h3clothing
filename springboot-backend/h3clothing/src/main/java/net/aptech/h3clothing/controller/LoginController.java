package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.LoginDTO;
import net.aptech.h3clothing.dto.SignUpRequest;
import net.aptech.h3clothing.dto.response.ApiResponse;
import net.aptech.h3clothing.dto.response.JWTResponse;
import net.aptech.h3clothing.entity.Role;
import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.entity.enums.Rolename;
import net.aptech.h3clothing.exception.AppException;
import net.aptech.h3clothing.exception.ApplicationException;
import net.aptech.h3clothing.jwt.TokenJWTUtil;
import net.aptech.h3clothing.repository.RoleRepository;
import net.aptech.h3clothing.repository.UserRepository;
import net.aptech.h3clothing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    LoginService service;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            JWTResponse response = service.login(loginDTO);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Login Failed !");
        }

    }

//    @RolesAllowed({"ROLE_ADMIN"})
    @PreAuthorize ("hasAuthority('ADMIN')")
    @GetMapping("/ok")

    public String ok() {
        return "OK";
    }
    @PreAuthorize ("hasAuthority('USER')")
    @GetMapping("/oks")
    public String oks() {
        return "OK";
    }

}

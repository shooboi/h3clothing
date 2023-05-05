package net.aptech.h3clothing.controller;

import net.aptech.h3clothing.dto.LoginDTO;
import net.aptech.h3clothing.dto.response.JWTResponse;
import net.aptech.h3clothing.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

  final LoginService service;

  public LoginController(LoginService service) {
    this.service = service;
  }

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
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/ok")

  public String ok() {
    return "OK";
  }

  @PreAuthorize("hasAuthority('USER')")
  @GetMapping("/oks")
  public String oks() {
    return "OK";
  }

}

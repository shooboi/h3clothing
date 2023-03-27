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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    LoginService service;

    @Autowired
    TokenJWTUtil tokenJWTUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO){
        try{


            System.out.println(loginDTO.getEmail());
            JWTResponse response = service.login(loginDTO);
            return ResponseEntity.ok(response);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Login Failed !");
        }

    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDTO) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginDTO.getEmail(),
//                        loginDTO.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = tokenJWTUtil.generateToken(authentication);
//        return ResponseEntity.ok(new JWTResponse(jwt));
//    }

    @GetMapping("/ok")
    public String ok(){
        return "OK";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role userRole = roleRepository.findByName(Rolename.ROLE_USER)
//                .orElseThrow(() -> new AppException("User Role not set."));
//
//        user.setRoleSet(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{email}")
                .buildAndExpand(result.getEmail()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}

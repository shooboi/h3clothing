package net.aptech.h3clothing.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.LoginDTO;
import net.aptech.h3clothing.dto.response.JWTResponse;
import net.aptech.h3clothing.controller.jwt.TokenJWTUtil;
import net.aptech.h3clothing.repository.UserRepository;
import net.aptech.h3clothing.security.CustomerUserDetail;
import net.aptech.h3clothing.service.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

  final AuthenticationManager authenticationManager;

  final UserRepository repository;

  final TokenJWTUtil tokenJWTUtil;

  @Override
  public JWTResponse login(LoginDTO u) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            u.getEmail(),
            u.getPassword()
        )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = tokenJWTUtil.generateJwtToken(authentication);

    CustomerUserDetail userDetails = (CustomerUserDetail) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return new JWTResponse(token, u.getEmail(), roles);
  }
}

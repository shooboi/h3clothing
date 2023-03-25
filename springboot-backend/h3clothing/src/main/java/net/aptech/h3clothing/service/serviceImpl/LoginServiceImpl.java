package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.LoginDTO;
import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.dto.response.JWTResponse;
import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.jwt.TokenJWTUtil;
import net.aptech.h3clothing.repository.UserRepository;
import net.aptech.h3clothing.security.CustomerUserDetail;
import net.aptech.h3clothing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository repository;

    @Autowired
    TokenJWTUtil tokenJWTUtil;

    @Override
    public JWTResponse login(LoginDTO u) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            u.getEmail(),
                            u.getPassword()
                    )
            );
            CustomerUserDetail userDetail = (CustomerUserDetail) authentication.getPrincipal();
            String token = tokenJWTUtil.generateToken(userDetail.getUser());

        return new JWTResponse(token,u.getEmail());
    }
}

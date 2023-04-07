package net.aptech.h3clothing.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.security.CustomerUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
@Slf4j
@Component
public class TokenJWTUtil {
    static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;
    static final String SECRET_KEY = "jwtKey56789";

    public String generateJwtToken(Authentication authentication) {

        CustomerUserDetail userPrincipal = (CustomerUserDetail) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String generateJwtTokenWithoutAuth(User user) {
        return Jwts.builder()
                .setSubject((user.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public  boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT Token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT Token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}

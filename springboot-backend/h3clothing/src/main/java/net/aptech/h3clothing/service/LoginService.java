package net.aptech.h3clothing.service;

import net.aptech.h3clothing.dto.LoginDTO;
import net.aptech.h3clothing.dto.response.JWTResponse;
import net.aptech.h3clothing.entity.User;

public interface LoginService {
    JWTResponse login(LoginDTO u);
}

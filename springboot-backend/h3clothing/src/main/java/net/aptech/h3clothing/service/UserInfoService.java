package net.aptech.h3clothing.service;

import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.entity.User_Info;

public interface UserInfoService {
    public User_Info getUserInfoByUserId(Integer userId);
}

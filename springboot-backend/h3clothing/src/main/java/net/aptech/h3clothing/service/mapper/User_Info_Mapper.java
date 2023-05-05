package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.entity.User_Info;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface User_Info_Mapper {

  UserInfDTO getUserInfoDTOFromUserInfo(User_Info user);

  User_Info getUserInfoFromUserInfoDTO(UserInfDTO userInfDTO);

  void updateUserInfo(UserInfDTO userInfDTO, @MappingTarget User_Info userInfo);

}

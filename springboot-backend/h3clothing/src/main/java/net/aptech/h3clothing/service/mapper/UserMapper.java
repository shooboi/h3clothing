package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

  UserDTO getUserDTOFromUser(User user);
  User getUserFromUserDTO(UserDTO userDTO);

  void updateUser(UserDTO userDTO, @MappingTarget User user);


}

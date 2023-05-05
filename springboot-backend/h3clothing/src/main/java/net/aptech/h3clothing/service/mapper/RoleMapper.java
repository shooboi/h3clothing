package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.RoleDTO;
import net.aptech.h3clothing.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RoleMapper {
  RoleDTO getRoleDTOFromRole(Role role);

  Role getRoleFromRoleDTO(RoleDTO roleDTO);

  void updateRole(RoleDTO roleDTO, @MappingTarget Role role);

}

package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.RoleDTO;
import net.aptech.h3clothing.entity.Role;
import net.aptech.h3clothing.exception.DuplicateException;
import net.aptech.h3clothing.repository.RoleRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements GenericService<RoleDTO> {

  final RoleRepository roleRepository;

  final RoleMapper roleMapper;

  @Override
  public List<RoleDTO> getAll() {
    return roleRepository.findAll().stream().map(roleMapper::getRoleDTOFromRole).collect(
        Collectors.toList());
  }

  @Override
  public RoleDTO add(RoleDTO roleDTO) {
    if (roleRepository.findByName(roleDTO.getRoleName()).isPresent()) {
      throw new DuplicateException("RoleName exists");
    } else {
      Role r = roleRepository.save(roleMapper.getRoleFromRoleDTO(roleDTO));
      return new RoleDTO(r.getRoleName());
    }
  }

  @Override
  public RoleDTO update(int id, RoleDTO roleDTO) {
    Role role = roleRepository.getById(id);
    roleMapper.updateRole(roleDTO, role);
    roleRepository.save(role);
    return roleMapper.getRoleDTOFromRole(role);
  }


  @Override
  public Optional<RoleDTO> getById(int id) {
    return Optional.of(roleMapper.getRoleDTOFromRole(roleRepository.getById(id)));
  }

  @Override
  public void remove(int id) {
    roleRepository.deleteById(id);
  }

}

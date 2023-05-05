package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.exception.DuplicateException;
import net.aptech.h3clothing.repository.RoleRepository;
import net.aptech.h3clothing.repository.UserRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements GenericService<UserDTO> {

  final RoleRepository roleRepository;

  final BCryptPasswordEncoder passwordEncoder;
  final UserRepository repository;

  final UserMapper userMapper;


  @Override
  public List<UserDTO> getAll() {
    return repository.findAll().stream().map(userMapper::getUserDTOFromUser)
        .collect(Collectors.toList());
  }

  @Override
  public UserDTO add(UserDTO userDTO) {
    if (repository.existsByEmail(userDTO.getEmail()) == null) {
      User us = userMapper.getUserFromUserDTO(userDTO);
      us.setRoleSet(Set.of(roleRepository.getById(1)));
      us.setPassword(passwordEncoder.encode(userDTO.getPassword()));

      User u = repository.save(us);
      return new UserDTO(u.getEmail(), u.getPassword());
    } else {
      throw new DuplicateException("Email exists !");
    }
  }

  @Override
  public UserDTO update(int id, UserDTO userDTO) {
    User user = repository.getById(id);
    userMapper.updateUser(userDTO, user);
    repository.save(user);
    return userMapper.getUserDTOFromUser(user);
  }

  @Override
  public void remove(int id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<UserDTO> getById(int id) {
    return Optional.ofNullable(userMapper.getUserDTOFromUser(repository.getById(id)));
  }

}


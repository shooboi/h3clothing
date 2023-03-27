package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.exception.DuplicateException;
import net.aptech.h3clothing.repository.RoleRepository;
import net.aptech.h3clothing.repository.UserRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements GenericService<UserDTO> {
    @Autowired
    Utility utility;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO save(UserDTO user) {
        if (!repository.existsByEmail(user.getEmail())) {
            User us = utility.convertUserFromUserDTO(user);
            us.setRoleSet(Set.of(roleRepository.getById(2)));
            us.setPassword(passwordEncoder.encode(user.getPassword()));

            User u = repository.save(us);
            return new UserDTO(u.getEmail(), u.getPassword());
        } else {
            throw new DuplicateException("Email does not exists !");
        }
    }

    @Override
    public List<UserDTO> getAll() {
        return utility.convertUserDTOFromUsers(repository.findAll());
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> getById(int id) {
        return Optional.of(utility.convertUserDTOFromUser(repository.getById(id)));
    }

}


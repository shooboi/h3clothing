package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.RoleDTO;
import net.aptech.h3clothing.entity.Role;
import net.aptech.h3clothing.exception.DuplicateException;
import net.aptech.h3clothing.repository.RoleRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class RoleServiceImpl implements GenericService<RoleDTO>{
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    Utility utility;
    @Override
    public List<RoleDTO> getAll() {
        return utility.convertRoleDTOFromRoles(roleRepository.findAll());
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        if(roleRepository.findByName(roleDTO.getRoleName()).isPresent()){
            throw new DuplicateException("RoleName exists");
        }else{
            Role r =  roleRepository.save(utility.convertRoleFromRoleDTO(roleDTO));
            return new RoleDTO(r.getRoleName());
        }

    }

    @Override
    public Optional<RoleDTO> getById(int id) {
        return Optional.of(utility.convertRoleDTOFromRole(roleRepository.getById(id)));
    }

    @Override
    public void remove(int id) {
        roleRepository.deleteById(id);
    }

}

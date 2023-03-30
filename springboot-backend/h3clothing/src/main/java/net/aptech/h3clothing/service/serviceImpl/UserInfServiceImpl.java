package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.entity.User_Info;
import net.aptech.h3clothing.repository.UserInf_Repository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserInfServiceImpl implements GenericService<UserInfDTO> {
    @Autowired
    UserInf_Repository userInfRepository;

    @Autowired
    Utility utility;
    @Override
    public List<UserInfDTO> getAll() {
        return utility.convertUserInfDTOFromUserInfList(userInfRepository.findAll());
    }

    @Override
    public UserInfDTO save(UserInfDTO userInfDTO) {
        User_Info userInfo = userInfRepository.save(utility.convertUserInfFromUserInfDTO(userInfDTO));
        return new UserInfDTO(userInfDTO.getFullName(), userInfDTO.getPhoneNumber(),userInfDTO.getAddress(),userInfDTO.isDeleted(),userInfDTO.getDob());
    }

    @Override
    public Optional<UserInfDTO> getById(int id) {
        return Optional.of(utility.convertUserInfDTOFromUserInf(userInfRepository.getById(id)));
    }

    @Override
    public void remove(int id) {
        userInfRepository.deleteById(id);
    }
}

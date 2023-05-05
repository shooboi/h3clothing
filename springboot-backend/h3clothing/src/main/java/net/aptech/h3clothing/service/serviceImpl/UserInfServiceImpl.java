package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.UserInfDTO;
import net.aptech.h3clothing.entity.User_Info;
import net.aptech.h3clothing.repository.UserInf_Repository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.User_Info_Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserInfServiceImpl implements GenericService<UserInfDTO> {

  final UserInf_Repository userInfRepository;

  final User_Info_Mapper userInfoMapper;

  @Override
  public List<UserInfDTO> getAll() {
    return userInfRepository.findAll().stream().map(userInfoMapper::getUserInfoDTOFromUserInfo)
        .collect(
            Collectors.toList());
  }

  @Override
  public UserInfDTO add(UserInfDTO userInfDTO) {
    User_Info userInfo = userInfRepository.save(
        userInfoMapper.getUserInfoFromUserInfoDTO(userInfDTO));
    return userInfoMapper.getUserInfoDTOFromUserInfo(userInfo);
  }

  @Override
  public UserInfDTO update(int id, UserInfDTO userInfDTO) {
    User_Info userInfo = userInfRepository.getById(id);
    userInfoMapper.updateUserInfo(userInfDTO, userInfo);
    userInfRepository.save(userInfo);
    return userInfoMapper.getUserInfoDTOFromUserInfo(userInfo);
  }

  @Override
  public Optional<UserInfDTO> getById(int id) {
    return Optional.ofNullable(
        userInfoMapper.getUserInfoDTOFromUserInfo(userInfRepository.getById(id)));
  }

  @Override
  public void remove(int id) {
    userInfRepository.deleteById(id);
  }
}

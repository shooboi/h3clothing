package net.aptech.h3clothing.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.SizeDTO;
import net.aptech.h3clothing.entity.Size;
import net.aptech.h3clothing.repository.SizeRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SizeServiceImpl implements GenericService<SizeDTO> {

  final SizeRepository sizeRepository;


  @Override
  public List<SizeDTO> getAll() {
    return null;
  }

  @Override
  public SizeDTO add(SizeDTO sizeDTO) {
    return null;
  }

  @Override
  public SizeDTO update(int id, SizeDTO sizeDTO) {
    return null;
  }


  @Override
  public Optional<SizeDTO> getById(int id) {
    return null;
  }

  @Override
  public void remove(int id) {
    sizeRepository.deleteById(id);
  }
}

package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.repository.Thumbnail_Repository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.ThumbnailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ThumbnailServiceImpl implements GenericService<ThumbnailDTO> {

  final Thumbnail_Repository thumbnailRepository;
  final ThumbnailMapper thumbnailMapper;

  @Override
  public List<ThumbnailDTO> getAll() {
    return thumbnailRepository.findAll().stream().map(thumbnailMapper::getThumbnailDTOFromThumbnail)
        .collect(Collectors.toList());
  }

  @Override
  public ThumbnailDTO add(ThumbnailDTO thumbnailDTO) {
    return null;
  }

  @Override
  public ThumbnailDTO update(int id, ThumbnailDTO thumbnailDTO) {
    return null;
  }


  @Override
  public Optional<ThumbnailDTO> getById(int id) {
    return Optional.ofNullable(
        thumbnailMapper.getThumbnailDTOFromThumbnail(thumbnailRepository.getById(id)));
  }

  @Override
  public void remove(int id) {
    thumbnailRepository.deleteById(id);
  }
}

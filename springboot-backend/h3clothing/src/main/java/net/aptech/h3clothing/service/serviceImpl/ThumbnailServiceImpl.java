package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.entity.Thumbnail_Image;
import net.aptech.h3clothing.repository.Thumbnail_Repository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ThumbnailServiceImpl implements GenericService<ThumbnailDTO> {
    @Autowired
    Thumbnail_Repository thumbnailRepository;

    @Autowired
    Utility utility;

    @Override
    public List<ThumbnailDTO> getAll() {
        return utility.convertThumbnailDTOFromThumbnails(thumbnailRepository.findAll());
    }

    @Override
    public ThumbnailDTO save(ThumbnailDTO thumbnailDTO) {
        Thumbnail_Image ti = thumbnailRepository.save(utility.convertThumbnailFromThumbnailDTO(thumbnailDTO));
        return new ThumbnailDTO(ti.getImageUrl());
    }

    @Override
    public Optional<ThumbnailDTO> getById(int id) {
        return Optional.of(utility.convertThumbnailDTOFromThumbnail(thumbnailRepository.getById(id)));
    }

    @Override
    public void remove(int id) {
        thumbnailRepository.deleteById(id);
    }
}

package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.ThumbnailDTO;
import net.aptech.h3clothing.entity.Thumbnail_Image;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ThumbnailMapper {

  ThumbnailDTO getThumbnailDTOFromThumbnail(Thumbnail_Image thumbnailImage);

  Thumbnail_Image getThumbnailFromThumbnailDTO(ThumbnailDTO thumbnailDTO);

  void updateThumbnail(ThumbnailDTO thumbnailDTO, @MappingTarget Thumbnail_Image thumbnailImage);

}

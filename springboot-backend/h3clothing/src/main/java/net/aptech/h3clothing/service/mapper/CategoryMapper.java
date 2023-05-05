package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

  Category getCategoryFromCategoryDTO(CategoryDTO categoryDTO);

  CategoryDTO getCategoryDTOFromCategory(Category category);

  void updateCategory(CategoryDTO categoryDTO, @MappingTarget Category category);
}

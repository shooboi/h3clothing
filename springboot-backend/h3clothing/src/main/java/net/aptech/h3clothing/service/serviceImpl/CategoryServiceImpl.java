package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.entity.Category;
import net.aptech.h3clothing.exception.NotFoundException;
import net.aptech.h3clothing.repository.CategoryRepository;
import net.aptech.h3clothing.service.CategoryService;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements GenericService<CategoryDTO>, CategoryService {

  final CategoryRepository categoryRepository;


  final CategoryMapper categoryMapper;

  @Override
  public List<CategoryDTO> getAll() {
    return categoryRepository.findAll().stream().map(categoryMapper::getCategoryDTOFromCategory)
        .collect(
            Collectors.toList());
  }

  @Override
  public CategoryDTO add(CategoryDTO categoryDTO) {
    Category category = categoryRepository.save(
        categoryMapper.getCategoryFromCategoryDTO(categoryDTO));
    return categoryMapper.getCategoryDTOFromCategory(category);
  }

  @Override
  public CategoryDTO update(int id, CategoryDTO categoryDTO) {
    Category category = categoryRepository.getById(id);
    categoryMapper.updateCategory(categoryDTO, category);
    categoryRepository.save(category);
    return categoryMapper.getCategoryDTOFromCategory(category);
  }

  @Override
  public Optional<CategoryDTO> getById(int id) {
    if (id == 0) {
      throw new NotFoundException("Id not found");
    }
    Category category = categoryRepository.getById(id);
    return Optional.ofNullable(categoryMapper.getCategoryDTOFromCategory(category));
  }

  @Override
  public void remove(int id) {
    if (id == 0) {
      throw new NotFoundException("Id not found");
    }
    categoryRepository.deleteById(id);
  }

  @Override
  public List<CategoryDTO> getAllParentRoot() {
    return categoryRepository.getAllParentRoot().stream()
        .map(categoryMapper::getCategoryDTOFromCategory).collect(
            Collectors.toList());
  }

  @Override
  public List<CategoryDTO> getChildCategoryFromParent() {
    return null;
  }
}

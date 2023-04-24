package net.aptech.h3clothing.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.entity.Category;
import net.aptech.h3clothing.exception.NotFoundException;
import net.aptech.h3clothing.repository.CategoryRepository;
import net.aptech.h3clothing.service.CategoryService;
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
public class CategoryServiceImpl implements GenericService<CategoryDTO>, CategoryService {

  final CategoryRepository categoryRepository;

  @Autowired
  Utility utility;

  @Override
  public List<CategoryDTO> getAll() {
    return utility.convertCategoryDTOFromCategories(categoryRepository.findAll());
  }

  @Override
  public CategoryDTO save(CategoryDTO categoryDTO) {
    Category category = categoryRepository.save(
        utility.convertCategoryFromCategoryDTO(categoryDTO));
    return new CategoryDTO(category.getTitle(), category.getParentId());
  }

  @Override
  public Optional<CategoryDTO> getById(int id) {
    if (id == 0) {
      throw new NotFoundException("Id not found");
    }
    return Optional.of(utility.convertCategoryDTOFromCategory(categoryRepository.getById(id)));
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
    return utility.convertCategoryDTOFromCategories(categoryRepository.getAllParentRoot());
  }

  @Override
  public List<CategoryDTO> getChildCategoryFromParent() {
    return null;
  }

//  public String getChild(int parent, int next){
//    if(next == 0) return "NONE";
//  if(parent >= 0){
//
//  }
//
//  }
}

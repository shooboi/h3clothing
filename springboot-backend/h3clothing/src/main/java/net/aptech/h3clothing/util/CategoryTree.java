package net.aptech.h3clothing.util;

import java.util.ArrayList;
import java.util.List;
import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.entity.Category;
import net.aptech.h3clothing.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryTree {

  @Autowired
  CategoryRepository repository;

  @Autowired
  Utility utility;

  public CategoryTree() {

  }


  public List<CategoryDTO> displayCategoryListTree() {
    List<Category> categories = repository.findAll();
    List<CategoryDTO> categoryDTOS = new ArrayList<>();
    for (Category category : categories) {
      if (category.getParentId() == 0) {
        categoryDTOS.add(displayCategoryChildTree(category, 0));
      }
    }
    return categoryDTOS;
  }


  public CategoryDTO displayCategoryChildTree(Category category, int level) {
    CategoryDTO dto = new CategoryDTO();
    dto.setId(category.getId());
    dto.setTitle(category.getTitle());
    dto.setParentId(category.getParentId());
    // Lấy danh sách các nút con của category
    List<Category> childCategories = getAllChildCategories(category.getId());

    List<CategoryDTO> children = new ArrayList<>();
    // Duyệt qua danh sách các nút con và hiển thị chúng
    for (Category childCategory : childCategories) {
      children.add(displayCategoryChildTree(childCategory, level + 1));
    }
    dto.setChild(children);
    return dto;
  }


  public List<Category> getAllChildCategories(int parentId) {
    return repository.getAllChildFromParent(parentId);
  }


}
package net.aptech.h3clothing.util;

import java.util.ArrayList;
import java.util.List;
import net.aptech.h3clothing.entity.Category;
import net.aptech.h3clothing.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryTree {

  @Autowired
  CategoryRepository repository;

  public void displayCategoryListTree() {
    List<Category> categories = repository.findAll();
    for (Category category : categories) {
      if (category.getParentId() == 0) {
        displayCategoryChildTree(category, 0);
      }
    }
  }


  public void displayCategoryChildTree(Category category, int level) {
    // Hiển thị tên của category ở mức độ hiện tại
    for (int i = 0; i < level; i++) {
      System.out.print("-");
    }
    System.out.println(category.getTitle());

    // Lấy danh sách các nút con của category
    List<Category> childCategories = getAllChildCategories(category.getId());

    // Duyệt qua danh sách các nút con và hiển thị chúng
    for (Category childCategory : childCategories) {
      displayCategoryChildTree(childCategory, level + 1);
    }
  }


  public List<Category> getAllChildCategories(int parentId) {
    return repository.getAllChildFromParent(parentId);
  }
}
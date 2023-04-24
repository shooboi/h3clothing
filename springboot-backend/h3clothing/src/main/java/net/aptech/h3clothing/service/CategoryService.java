package net.aptech.h3clothing.service;

import java.util.List;
import net.aptech.h3clothing.dto.CategoryDTO;

public interface CategoryService {
  List<CategoryDTO> getAllParentRoot();
  List<CategoryDTO> getChildCategoryFromParent();

}

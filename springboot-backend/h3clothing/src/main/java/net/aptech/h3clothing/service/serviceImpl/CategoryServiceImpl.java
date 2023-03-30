package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.CategoryDTO;
import net.aptech.h3clothing.entity.Category;
import net.aptech.h3clothing.repository.CategoryRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements GenericService<CategoryDTO> {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    Utility utility;

    @Override
    public List<CategoryDTO> getAll() {
        return utility.convertCategoryDTOFromCategories(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(utility.convertCategoryFromCategoryDTO(categoryDTO));
        return new CategoryDTO(category.getTitle(), category.getParentId());
    }

    @Override
    public Optional<CategoryDTO> getById(int id) {
        return Optional.of(utility.convertCategoryDTOFromCategory(categoryRepository.getById(id)));
    }

    @Override
    public void remove(int id) {
        categoryRepository.deleteById(id);
    }
}

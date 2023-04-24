package net.aptech.h3clothing.repository;

import java.util.List;
import net.aptech.h3clothing.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

  @Query("SELECT c FROM Category c WHERE c.parentId = 0")
  List<Category> getAllParentRoot();

  @Query("SELECT c FROM Category c WHERE c.parentId = ?1")
  List<Category> getAllChildFromParent(int parent);
}

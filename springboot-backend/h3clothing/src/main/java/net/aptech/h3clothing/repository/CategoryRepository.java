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

//  @Query(value = "WITH RECURSIVE subcategories AS ( "
//      + "  SELECT id, title, parent_id FROM Category WHERE parent_id = ?1 "
//      + "  UNION ALL "
//      + "  SELECT c.id, c.title, c.parent_id FROM Category c "
//      + "  JOIN subcategories sc ON c.parent_id = sc.id "
//      + ") "
//      + "SELECT * FROM subcategories ",nativeQuery = true)
  @Query("SELECT c FROM Category  c WHERE c.parentId = ?1")
  List<Category> getAllChildFromParent(int parent);


}

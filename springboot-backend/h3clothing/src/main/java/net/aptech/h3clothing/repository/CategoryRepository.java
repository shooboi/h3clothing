package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

//    @Query("SELECT c FROM Category c WHERE")
}

package net.aptech.h3clothing.repository;

import java.util.Optional;
import net.aptech.h3clothing.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  @Query("SELECT p FROM Product p "
      + "WHERE (LENGTH(p.name) = 0 OR p.name LIKE %?1%)  "
      + "OR (p.id IS NULL OR p.id = ?2) "
      + "OR (LENGTH(p.description) = 0 OR p.description LIKE %?3%) "
      + "OR (p.price IS NULL OR p.price = ?4) "
  )
  Page<Product> findAllByPage(
      String name,
      Optional<Integer> id,
      String description,
      Optional<Double> price,
      Pageable pageable
  );
}

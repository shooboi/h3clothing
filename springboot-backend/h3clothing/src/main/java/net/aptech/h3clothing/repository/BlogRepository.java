package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}

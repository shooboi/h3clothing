package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.Thumbnail_Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Thumbnail_Repository extends JpaRepository<Thumbnail_Image,Integer> {
}

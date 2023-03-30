package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.Order_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Detail,Integer> {
}

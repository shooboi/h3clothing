package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public Optional<User> loadUserByEmail(String email);

//    List<User> findByIdIn(List<Long> userIds);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    boolean existsByEmail(String email);
}

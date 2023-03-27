package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.Role;
import net.aptech.h3clothing.entity.enums.Rolename;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.Rolename = ?1")
    Optional<Role> findByName(Rolename roleName);
}

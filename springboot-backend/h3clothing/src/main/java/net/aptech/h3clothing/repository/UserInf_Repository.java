package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInf_Repository extends JpaRepository<User_Info,Integer> {

}

package net.aptech.h3clothing.repository;

import net.aptech.h3clothing.entity.User;
import net.aptech.h3clothing.entity.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInf_Repository extends JpaRepository<User_Info,Integer> {
    @Query("SELECT ui FROM User_Info ui JOIN ui.user u WHERE u.id = ?1")
    User_Info findByUser_Id(Integer userId);

}

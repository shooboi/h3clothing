package net.aptech.h3clothing.entity;

import lombok.Data;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "user_info")
public class User_Info extends Base {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "dob")
    private Date dob;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User_Info() {
    }

    public User_Info(int id, User user, String fullName, String phoneNumber, String address, boolean isDeleted, Date dob) {
        super.setId(id);
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isDeleted = isDeleted;
        this.dob = dob;
        this.user = user;

    }
    public User_Info(String fullName, String phoneNumber, String address, boolean isDeleted, Date dob) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isDeleted = isDeleted;
        this.dob = dob;
    }
}

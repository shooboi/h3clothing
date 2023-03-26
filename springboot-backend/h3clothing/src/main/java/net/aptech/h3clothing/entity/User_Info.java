package net.aptech.h3clothing.entity;

import javax.persistence.*;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
}

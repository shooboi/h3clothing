package net.aptech.h3clothing.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "user_info")
public class User_Info extends Base {
    @NotBlank
    @Pattern(regexp = "([A-Za-z]+( [A-Za-z]+)+)")
    @Column(name = "fullname")
    private String fullName;

    @Size(max=10)
    @Pattern(regexp = "\\d")
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
    
}
